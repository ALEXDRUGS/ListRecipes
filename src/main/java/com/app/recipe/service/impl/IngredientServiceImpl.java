package com.app.recipe.service.impl;

import com.app.recipe.exceptions.ReadFromIngFileException;
import com.app.recipe.exceptions.SaveToIngFileException;
import com.app.recipe.model.Ingredient;
import com.app.recipe.service.IngredientService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
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
    public void init() throws IOException {
        readFromIngFile();
    }
    @Override
    public Ingredient addIngredient(Ingredient ingredient) throws IOException {
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
    public Ingredient updateIngredient(Integer id, Ingredient ingredient) throws IOException {
        ingredients.replace(id, ingredient);
        saveToIngFile();
        return ingredient;
    }
    @Override
    public void deleteIngredient(Integer id) {
        ingredients.remove(id);
    }
    @Override
    public void saveToIngFile() throws IOException {
        try {
            String json = new ObjectMapper().writeValueAsString(ingredients);
            fileServiceImpl.saveToIngFile(json);
        } catch (SaveToIngFileException e) {
            e.saveToIngFileException();
        }
    }
    @Override
    public void readFromIngFile() throws IOException {
        try {
            String json = fileServiceImpl.readFromIngFile();
            ingredients = new ObjectMapper().readValue(json, new TypeReference<HashMap<Integer, Ingredient>>() {
            });
        } catch (ReadFromIngFileException e) {
            e.readFromIngFileException();
        }
    }
}
