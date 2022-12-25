package com.app.recipe.model;

import lombok.Data;

@Data
public class Step {
    private String step;

    public Step(String step) {
        this.step = step;
    }

    @Override
    public String toString() {
        return "Шаг " + step;
    }
}
