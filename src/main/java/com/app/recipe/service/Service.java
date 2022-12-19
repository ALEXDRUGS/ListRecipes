package com.app.recipe.service;

import com.app.recipe.model.Ingredient;
import com.app.recipe.model.Recipe;

import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class Service {
    private static final Map<Integer, Recipe> RECIPE_MAP = new TreeMap<>();
    private static final LinkedList<Ingredient> INGREDIENT_LIST = new LinkedList<>();
    private static Integer id = 0;

    public void addIngredient(LinkedList<Ingredient> ingredients) {
        INGREDIENT_LIST.addAll(ingredients);
    }

    public String getIngredient() {
        return INGREDIENT_LIST.toString();
    }

    public void addRecipe(Recipe recipe) {
        if (!RECIPE_MAP.containsValue(recipe)) {
            RECIPE_MAP.put(id++, recipe);
        }
    }

    public String getRecipe() {
        return RECIPE_MAP.entrySet().toString();
    }
}
