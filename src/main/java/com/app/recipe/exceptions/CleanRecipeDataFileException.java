package com.app.recipe.exceptions;

import java.io.IOException;

public class CleanRecipeDataFileException extends IOException {
    public void cleanRecipeDataFileException() {
        System.out.println("File of recipe don't has been saved");
    }
}
