package com.app.recipe.service;

import java.io.File;

public interface FileService {
    void saveToRecipeFile(String json);

    void saveToIngFile(String json);

    String readFromRecipeFile();

    String readFromIngFile();

    void cleanRecipeDataFile();

    void cleanIngDataFile();

    File getRecipeDataFile();

    File getIngDataFile();
}
