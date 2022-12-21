package com.app.recipe.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Step {
    private String step;

    @Override
    public String toString() {
        return "Шаг " + step;
    }
}
