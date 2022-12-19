package com.app.recipe.service.impl;

import com.app.recipe.model.Recipe;
import com.app.recipe.service.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;
import java.util.TreeMap;

public class ServiceImpl implements Service {
    private static final Map<Integer, Recipe> RECIPE_MAP = new TreeMap<>();
    private static Integer id = 0;

    public static void addRecipe(@RequestBody Recipe recipe) {
            RECIPE_MAP.put(id++, recipe);
    }

    public static Recipe getRecipe() {
        return RECIPE_MAP.get(id);
    }
}
