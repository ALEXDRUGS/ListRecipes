package com.app.recipe.service;

import com.app.recipe.model.Ingredient;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class IngredientService {
    private final Map<Integer, Ingredient> ingredients = new TreeMap<>();
    private Integer id = 0;

    public Ingredient addIngredient(Ingredient ingredient) {
        ingredients.put(id++, ingredient);
        return ingredient;
    }

    public Ingredient getIngredient(Integer id) {
        return ingredients.get(id);
    }

    public Ingredient updateIngredient(Integer id, Ingredient ingredient) {
        ingredients.replace(id, ingredient);
        return ingredient;
    }

    public void deleteIngredient(Integer id) {
        ingredients.remove(id);
    }
}
