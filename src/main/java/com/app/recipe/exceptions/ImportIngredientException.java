package com.app.recipe.exceptions;

import java.io.IOException;

public class ImportIngredientException extends IOException {
    public void importIngredientException() {
        System.out.println("File of ingredients don't has been imported");
    }
}
