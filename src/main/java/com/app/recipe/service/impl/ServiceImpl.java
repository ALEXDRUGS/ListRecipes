package com.app.recipe.service.impl;

import com.app.recipe.model.Ingredient;
import com.app.recipe.model.Recipe;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ServiceImpl {
    private static final Map<Integer, Recipe> RECIPE_MAP = new TreeMap<>();
    private static final List<Ingredient> INGREDIENT = new ArrayList<>();
    private static final List<String> PREPARING_STEPS = new ArrayList<>();

    private static Integer id = 0;

    public static void addRecipe(Recipe recipe) {
        RECIPE_MAP.put(id++, recipe);
    }

    public static String getRecipe() {
        return RECIPE_MAP.toString();
    }

    public static void addIngredient(Ingredient ingredient) {
        INGREDIENT.add(id, ingredient);
    }

    public static String getIngredient() {
        return INGREDIENT.toString();
    }
    // public static void addStep()
}
