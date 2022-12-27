package com.app.recipe.service;

import com.app.recipe.model.Ingredient;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

@Service
public class IngredientService {
    private final LinkedList<Ingredient> ingredients = new LinkedList<>();
    private Integer id = 0;

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(id, ingredient);
    }

    public Ingredient getIngredient(Integer id) {
        return ingredients.get(id);
    }

    public Ingredient updateIngredient(Integer id, Ingredient ingredient) {
        ingredients.set(id, ingredient);
        return ingredient;
    }

    public void deleteIngredient(Integer id) {
        ingredients.remove(id);
    }
}
