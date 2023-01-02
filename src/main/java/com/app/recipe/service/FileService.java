package com.app.recipe.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class FileService {

    @Value("${path.to.recipe.file}")
    private String recipeFilePath;
    @Value("${name.of.recipe.file}")
    private String recipeFileName;
    @Value("${path.to.ingredient.file}")
    private String ingredientFilePath;
    @Value("${name.of.ingredient.file}")
    private String ingredientFileName;

    public void saveToRecipeFile(String json) {
        try {
            cleanRecipeDataFile();
            Files.writeString(Path.of(recipeFilePath, recipeFileName), json);
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    public void saveToIngFile(String json) {
        try {
            cleanIngDataFile();
            Files.writeString(Path.of(ingredientFilePath, ingredientFileName), json);
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    public String readFromRecipeFile() {
        try {
            return Files.readString(Path.of(recipeFilePath, recipeFileName));
        } catch (IOException e) {
            e.getStackTrace();
            throw new RuntimeException();
        }
    }

    public String readFromIngFile() {
        try {
            return Files.readString(Path.of(ingredientFilePath, ingredientFileName));
        } catch (IOException e) {
            e.getStackTrace();
            throw new RuntimeException();
        }
    }

    private void cleanRecipeDataFile() {
        try {
            Files.deleteIfExists(Path.of(recipeFilePath, recipeFileName));
            Files.createFile(Path.of(recipeFilePath, recipeFileName));
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    private void cleanIngDataFile() {
        try {
            Files.deleteIfExists(Path.of(ingredientFilePath, ingredientFileName));
            Files.createFile(Path.of(ingredientFilePath, ingredientFileName));
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    public File getRecipeDataFile() {
        return new File(recipeFilePath + "/" + recipeFileName);
    }

    public File getIngDataFile() {
        return new File(ingredientFilePath + "/" + ingredientFileName);
    }
}
