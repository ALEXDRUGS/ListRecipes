package com.app.recipe.service;

import com.app.recipe.model.Recipe;

import java.io.IOException;
import java.nio.file.Path;

public interface RecipeService {
    Recipe addRecipe(Recipe recipe) throws IOException;

    Recipe getRecipe(Integer id);

    Recipe updateRecipe(Integer id, Recipe recipe) throws IOException;

    void deleteRecipe(Integer id);

    void saveToFile() throws IOException;

    void readFromFile() throws IOException;

    Path createAllRecipesFile() throws IOException;
}
