package com.app.recipe.service;

import com.app.recipe.model.Ingredient;

public interface IngredientService {
    Ingredient addIngredient(Ingredient ingredient);

    Ingredient getIngredient(Integer id);

    Ingredient updateIngredient(Integer id, Ingredient ingredient);

    void deleteIngredient(Integer id);

    void saveToIngFile();

    void readFromIngFile();
}
