package com.app.recipe.service;

import com.app.recipe.model.Ingredient;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Service
public class IngredientService {
    private LinkedList<Ingredient> ingredients = new LinkedList<>();
    private static Integer id;

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(id, ingredient);
    }

    public Ingredient getIngredient(Integer id) {
        return ingredients.get(id);
    }
}
