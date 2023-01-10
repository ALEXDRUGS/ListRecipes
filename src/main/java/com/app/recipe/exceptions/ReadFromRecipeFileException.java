package com.app.recipe.exceptions;

import java.io.IOException;

public class ReadFromRecipeFileException extends IOException {
    public void readFromRecipeFileException() {
        System.out.println("File of recipe don't has been read");
    }
}
