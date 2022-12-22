package com.app.recipe.service;

import com.app.recipe.model.Recipe;

import java.util.Map;
import java.util.TreeMap;

@org.springframework.stereotype.Service

public class RecipeService {
    private static final Map<Integer, Recipe> RECIPE_MAP = new TreeMap<>();
    public static Integer id = 1;

    public static void addRecipe(Recipe recipe) {
        RECIPE_MAP.put(id++, recipe);
    }

    public static Recipe getRecipe(Integer id) {
        return RECIPE_MAP.get(id);
    }
}
