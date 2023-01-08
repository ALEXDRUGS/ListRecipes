package com.app.recipe.service;

import com.app.recipe.model.Recipe;

import java.io.IOException;
import java.nio.file.Path;

public interface RecipeService {
    Recipe addRecipe(Recipe recipe);

    Recipe getRecipe(Integer id);

    Recipe updateRecipe(Integer id, Recipe recipe);

    void deleteRecipe(Integer id);

    void saveToFile();

    void readFromFile();

    Path createAllRecipesFile() throws IOException;
}
