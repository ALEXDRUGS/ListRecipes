package com.app.recipe.service;

import com.app.recipe.model.Recipe;

import java.util.Map;
import java.util.TreeMap;

public class Service {
    private static final Map<Integer, Recipe> RECIPE_MAP = new TreeMap<>();
    private static Integer id = 0;

    public static void addRecipe(Recipe recipe) {
            RECIPE_MAP.put(id++, recipe);
    }

    public static Recipe getRecipe() {
        return RECIPE_MAP.get(id);
    }
}
