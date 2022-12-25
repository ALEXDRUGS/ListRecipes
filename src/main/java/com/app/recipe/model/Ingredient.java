package com.app.recipe.model;

import lombok.Data;
@Data
public class Ingredient {
    private String nameIngredient;
    private Integer count;
    private String measureUnit;
    private static Integer id;

    public Ingredient(String nameIngredient, Integer count, String measureUnit) {
        this.nameIngredient = nameIngredient;
        this.count = count;
        this.measureUnit = measureUnit;
    }

    @Override
    public String toString() {
        return " ингредиент: " + nameIngredient +
                ", количество: " + count +
                " " + measureUnit;
    }
}
