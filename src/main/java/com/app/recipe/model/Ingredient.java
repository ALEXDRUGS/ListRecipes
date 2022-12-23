package com.app.recipe.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Ingredient {
    private String nameIngredient;
    private Integer count;
    private String measureUnit;
    private Integer id;

    @Override
    public String toString() {
        return " ингредиент: " + nameIngredient +
                ", количество: " + count +
                " " + measureUnit;
    }
}
