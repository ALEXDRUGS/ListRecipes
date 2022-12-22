package com.app.recipe.service;

import com.app.recipe.model.Ingredient;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Service
public class IngredientService {
    private static final LinkedList<Ingredient> INGREDIENT = new LinkedList<>();
    private static Integer id;

    public static void addIngredient(Ingredient ingredient) {
        INGREDIENT.add(id, ingredient);
    }

    public static Ingredient getIngredient(Integer id) {
        return INGREDIENT.get(id);
    }
}
