package com.app.recipe.service;

import com.app.recipe.model.Ingredient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class IngredientService {
    private final FileService fileService;
    private Map<Integer, Ingredient> ingredients = new HashMap<>();
    private Integer id = 0;
    public IngredientService(FileService fileService) {
        this.fileService = fileService;
    }

    @PostConstruct
    public void init() {
        readFromIngFile();
    }

    public Ingredient addIngredient(Ingredient ingredient) {
        if (!ingredients.containsValue(ingredient)) {
            ingredients.put(id++, ingredient);
            saveToIngFile();
        }
        return ingredient;
    }

    public Ingredient getIngredient(Integer id) {
        return ingredients.get(id);
    }

    public Ingredient updateIngredient(Integer id, Ingredient ingredient) {
        ingredients.replace(id, ingredient);
        saveToIngFile();
        return ingredient;
    }

    public void deleteIngredient(Integer id) {
        ingredients.remove(id);
    }

    private void saveToIngFile() {
        try {
            String json = new ObjectMapper().writeValueAsString(ingredients);
            fileService.saveToIngFile(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    private void readFromIngFile() {
        try {
            String json = fileService.readFromIngFile();
            ingredients = new ObjectMapper().readValue(json, new TypeReference<HashMap<Integer, Ingredient>>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
