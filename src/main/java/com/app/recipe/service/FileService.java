package com.app.recipe.service;

import java.io.File;
import java.nio.file.Path;

public interface FileService {
    Path createAllRecipesFile(String suffix);

    void saveToRecipeFile(String json);

    void saveToIngFile(String json);

    String readFromRecipeFile();

    String readFromIngFile();

    void cleanRecipeDataFile();

    void cleanIngDataFile();

    File getRecipeDataFile();

    File getIngDataFile();
}
