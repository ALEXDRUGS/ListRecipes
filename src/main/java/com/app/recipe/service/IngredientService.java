package com.app.recipe.service;

import com.app.recipe.model.Ingredient;

import java.io.IOException;

public interface IngredientService {
    Ingredient addIngredient(Ingredient ingredient) throws IOException;

    Ingredient getIngredient(Integer id);

    Ingredient updateIngredient(Integer id, Ingredient ingredient) throws IOException;

    void deleteIngredient(Integer id);

    void saveToIngFile() throws IOException;

    void readFromIngFile() throws IOException;
}
