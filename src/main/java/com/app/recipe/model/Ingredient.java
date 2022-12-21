package com.app.recipe.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Ingredient {
    private String nameIngredient;
    private Integer count;
    private String measureUnit;
}