package com.app.recipe.exceptions;

import java.io.IOException;

public class SaveToRecipeFileException extends IOException {
    public void saveToRecipeFileException() {
        System.out.println("File of recipe don't has been saved");
    }
}
