package com.app.recipe.exceptions;

import java.io.IOException;

public class ImportRecipeException extends IOException {
    public void importRecipeException() {
        System.out.println("File of recipes don't has been imported");
    }
}
