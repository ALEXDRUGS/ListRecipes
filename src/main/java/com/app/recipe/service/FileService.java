package com.app.recipe.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public interface FileService {
    Path createAllRecipesFile(String suffix) throws IOException;

    void saveToRecipeFile(String json) throws IOException;

    void saveToIngFile(String json) throws IOException;

    String readFromRecipeFile() throws IOException;

    String readFromIngFile() throws IOException;

    void cleanRecipeDataFile() throws IOException;

    void cleanIngDataFile() throws IOException;

    File getRecipeDataFile();

    File getIngDataFile();
}
