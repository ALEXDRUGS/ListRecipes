package com.app.recipe.service;

import com.app.recipe.model.Ingredient;
import com.app.recipe.model.Recipe;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Service
public class IngredientService {
    private LinkedList<Ingredient> ingredients = new LinkedList<>();
    private Integer id;

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(id, ingredient);
    }

    public Ingredient getIngredient(Integer id) {
        return ingredients.get(id);
    }
    public Ingredient updateIngredient(Integer id, Ingredient ingredient) {
        return ingredients.set(id, ingredient);
    }

    public void deleteIngredient(Integer id) {
        ingredients.remove(id);
    }
}
