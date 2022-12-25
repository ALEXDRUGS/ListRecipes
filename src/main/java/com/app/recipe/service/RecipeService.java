package com.app.recipe.service;

import com.app.recipe.model.Recipe;

import java.util.Map;
import java.util.TreeMap;

@org.springframework.stereotype.Service

public class RecipeService {
    private final Map<Integer, Recipe> recipeMap = new TreeMap<>();
    public static Integer id = 0;

    public void addRecipe(Recipe recipe) {
        recipeMap.put(id++, recipe);
    }

    public Recipe getRecipe(Integer id) {
        return recipeMap.get(id);
    }

    public Recipe updateRecipe(Integer id, Recipe recipe) {
        if (recipeMap.containsKey(id)) {
            recipeMap.replace(id, recipe);
        }
        return recipe;
    }

    public void deleteRecipe(Integer id) {
        recipeMap.remove(id);
    }
}
