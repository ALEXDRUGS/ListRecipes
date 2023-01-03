package com.app.recipe.service.impl;

import com.app.recipe.model.Recipe;
import com.app.recipe.service.RecipeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@org.springframework.stereotype.Service

public class RecipeServiceImpl implements RecipeService {
    private final FileServiceImpl fileServiceImpl;
    private Map<Integer, Recipe> recipeMap = new HashMap<>();
    public Integer id = 0;

    public RecipeServiceImpl(FileServiceImpl fileServiceImpl) {
        this.fileServiceImpl = fileServiceImpl;
    }

    @PostConstruct
    private void init() {
        readFromFile();
    }

    @Override
    public Recipe addRecipe(Recipe recipe) {
        if (!recipeMap.containsValue(recipe)) {
            recipeMap.put(id++, recipe);
            saveToFile();
        }
        return recipe;
    }

    @Override
    public Recipe getRecipe(Integer id) {
        return recipeMap.get(id);
    }

    @Override
    public Recipe updateRecipe(Integer id, Recipe recipe) {
        if (recipeMap.containsKey(id)) {
            recipeMap.replace(id, recipe);
            saveToFile();
        }
        return recipe;
    }

    @Override
    public void deleteRecipe(Integer id) {
        recipeMap.remove(id);
    }

    @Override
    public void saveToFile() {
        try {
            String json = new ObjectMapper().writeValueAsString(recipeMap);
            fileServiceImpl.saveToRecipeFile(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void readFromFile() {
        try {
            String json = fileServiceImpl.readFromRecipeFile();
            recipeMap = new ObjectMapper().readValue(json, new TypeReference<HashMap<Integer, Recipe>>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
