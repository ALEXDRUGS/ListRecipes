package com.app.recipe.service;

import com.app.recipe.model.Recipe;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@org.springframework.stereotype.Service

public class RecipeService {
    private final FileService fileService;
    private Map<Integer, Recipe> recipeMap = new HashMap<>();
    public Integer id = 0;

    public RecipeService(FileService fileService) {
        this.fileService = fileService;
    }

    @PostConstruct
    private void init() {
        readFromFile();
    }

    public Recipe addRecipe(Recipe recipe) {
        if (!recipeMap.containsValue(recipe)) {
            recipeMap.put(id++, recipe);
            saveToFile();
        }
        return recipe;
    }

    public Recipe getRecipe(Integer id) {
        return recipeMap.get(id);
    }

    public Recipe updateRecipe(Integer id, Recipe recipe) {
        if (recipeMap.containsKey(id)) {
            recipeMap.replace(id, recipe);
            saveToFile();
        }
        return recipe;
    }

    public void deleteRecipe(Integer id) {
        recipeMap.remove(id);
    }

    private void saveToFile() {
        try {
            String json = new ObjectMapper().writeValueAsString(recipeMap);
            fileService.saveToRecipeFile(json);
        } catch (JsonProcessingException e) {
            e.getStackTrace();
        }
    }

    private void readFromFile() {
        try {
            String json = fileService.readFromFile();
            recipeMap = new ObjectMapper().readValue(json, new TypeReference<HashMap<Integer, Recipe>>() {
            });
        } catch (JsonProcessingException e) {
            e.getStackTrace();
        }
    }
}
