package com.app.recipe.exceptions;

import java.io.IOException;

public class ReadFromIngFileException extends IOException {
    public void readFromIngFileException() {
        System.out.println("File of ingredient don't has been read");
    }
}
