package com.app.recipe.service.impl;

import com.app.recipe.model.Ingredient;
import com.app.recipe.service.IngredientService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class IngredientServiceImpl implements IngredientService {
    private final FileServiceImpl fileServiceImpl;
    private Map<Integer, Ingredient> ingredients = new HashMap<>();
    private Integer id = 0;
    public IngredientServiceImpl(FileServiceImpl fileServiceImpl) {
        this.fileServiceImpl = fileServiceImpl;
    }

    @PostConstruct
    public void init() {
        readFromIngFile();
    }
    @Override
    public Ingredient addIngredient(Ingredient ingredient) {
        if (!ingredients.containsValue(ingredient)) {
            ingredients.put(id++, ingredient);
            saveToIngFile();
        }
        return ingredient;
    }
    @Override
    public Ingredient getIngredient(Integer id) {
        return ingredients.get(id);
    }
    @Override
    public Ingredient updateIngredient(Integer id, Ingredient ingredient) {
        ingredients.replace(id, ingredient);
        saveToIngFile();
        return ingredient;
    }
    @Override
    public void deleteIngredient(Integer id) {
        ingredients.remove(id);
    }
    @Override
    public void saveToIngFile() {
        try {
            String json = new ObjectMapper().writeValueAsString(ingredients);
            fileServiceImpl.saveToIngFile(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException("Something wrong");
        }
    }
    @Override
    public void readFromIngFile() {
        try {
            String json = fileServiceImpl.readFromIngFile();
            ingredients = new ObjectMapper().readValue(json, new TypeReference<HashMap<Integer, Ingredient>>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException("Something wrong");
        }
    }
}
