package com.app.recipe.exceptions;

import java.io.IOException;

public class CleanIngDataFileException extends IOException {
    public void cleanIngDataFileException() {
        System.out.println("File of ingredient don't has been saved");
    }
}
