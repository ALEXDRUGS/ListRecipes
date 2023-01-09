package com.app.recipe.exceptions;

import java.io.IOException;

public class SaveToIngFileException extends IOException {
    public void saveToIngFileException() {
        System.out.println("File of ingredient don't has been saved");
    }
}
