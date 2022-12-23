package com.app.recipe.service;

import com.app.recipe.model.Recipe;

import java.util.Map;
import java.util.TreeMap;

@org.springframework.stereotype.Service

public class RecipeService {
    private Map<Integer, Recipe> recipeMap = new TreeMap<>();
    public static Integer id = 1;

    public void addRecipe(Recipe recipe) {
        recipeMap.put(id++, recipe);
    }

    public Recipe getRecipe(Integer id) {
        return recipeMap.get(id);
    }
}
