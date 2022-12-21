package com.app.recipe.service;

import com.app.recipe.model.Ingredient;
import com.app.recipe.model.Recipe;
import com.app.recipe.model.Step;

import java.util.*;

@org.springframework.stereotype.Service
public class Service {
    private static final Map<Integer, Recipe> RECIPE_MAP = new TreeMap<>();
    private static final LinkedList<Ingredient> INGREDIENT = new LinkedList<>();
    private static final LinkedList<String> PREPARING_STEPS = new LinkedList<>();

    private static Integer id = 0;

    public static void addIngredient(Ingredient ingredient) {
        INGREDIENT.add(id, ingredient);
    }

    public static String getIngredient() {
        return INGREDIENT.toString();
    }

    public static void addStep(Step step) {
        PREPARING_STEPS.add(id, step.toString());
    }

    public static String getStep() {
        return PREPARING_STEPS.toString();
    }
    public static void addRecipe(Recipe recipe) {
        RECIPE_MAP.put(id++, recipe);
    }

    public static String getRecipe() {
        return RECIPE_MAP.toString();
    }
}
