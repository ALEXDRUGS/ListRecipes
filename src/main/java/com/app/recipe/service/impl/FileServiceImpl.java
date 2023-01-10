package com.app.recipe.service.impl;

import com.app.recipe.exceptions.*;
import com.app.recipe.service.FileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class FileServiceImpl implements FileService {

    @Value("${path.to.recipe.file}")
    private String recipeFilePath;
    @Value("${name.of.recipe.file}")
    private String recipeFileName;
    @Value("${path.to.ingredient.file}")
    private String ingredientFilePath;
    @Value("${name.of.ingredient.file}")
    private String ingredientFileName;

    @Override
    public Path createAllRecipesFile(String suffix) throws IOException {
        if (!Files.exists(Path.of(recipeFilePath))) {
            try {
                return Files.createFile(Path.of(recipeFilePath, suffix));
            } catch (CreateAllRecipesFileException e) {
                e.createAllRecipesFileException();
            }
        }
        return null;
    }

    @Override
    public void saveToRecipeFile(String json) throws IOException {
        try {
            cleanRecipeDataFile();
            Files.writeString(Path.of(recipeFilePath, recipeFileName), json);
        } catch (SaveToRecipeFileException e) {
            e.saveToRecipeFileException();
        }
    }

    @Override
    public void saveToIngFile(String json) throws IOException {
        try {
            cleanIngDataFile();
            Files.writeString(Path.of(ingredientFilePath, ingredientFileName), json);
        } catch (SaveToIngFileException e) {
            e.saveToIngFileException();
        }
    }

    @Override
    public String readFromRecipeFile() throws IOException {
        try {
            return Files.readString(Path.of(recipeFilePath, recipeFileName));
        } catch (ReadFromRecipeFileException e) {
            e.readFromRecipeFileException();
        }
        return null;
    }

    @Override
    public String readFromIngFile() throws IOException {
        try {
            return Files.readString(Path.of(ingredientFilePath, ingredientFileName));
        } catch (ReadFromIngFileException e) {
            e.readFromIngFileException();
        }
        return null;
    }

    @Override
    public void cleanRecipeDataFile() throws IOException {
        try {
            Files.deleteIfExists(Path.of(recipeFilePath, recipeFileName));
            Files.createFile(Path.of(recipeFilePath, recipeFileName));
        } catch (CleanRecipeDataFileException e) {
            e.cleanRecipeDataFileException();
        }
    }

    @Override
    public void cleanIngDataFile() throws IOException {
        try {
            Files.deleteIfExists(Path.of(ingredientFilePath, ingredientFileName));
            Files.createFile(Path.of(ingredientFilePath, ingredientFileName));
        } catch (CleanIngDataFileException e) {
            e.cleanIngDataFileException();
        }
    }

    @Override
    public File getRecipeDataFile() {
        return new File(recipeFilePath + "/" + recipeFileName);
    }

    @Override
    public File getIngDataFile() {
        return new File(ingredientFilePath + "/" + ingredientFileName);
    }

    public void deleteRecipe(Integer id) {
    }
}
