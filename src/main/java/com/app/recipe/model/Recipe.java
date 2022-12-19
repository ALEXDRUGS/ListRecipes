package com.app.recipe.model;

import lombok.Data;

import java.util.LinkedList;

@Data

public class Recipe {
    private String nameRecipe;
    private Integer preparingTime;
    private LinkedList<Ingredient> ingredients;
    private LinkedList<String> preparingSteps;

    public Recipe(String nameRecipe, Integer preparingTime, LinkedList<Ingredient> ingredients, LinkedList<String> preparingSteps) {
        this.nameRecipe = nameRecipe;
        this.preparingTime = preparingTime;
        this.ingredients = ingredients;
        this.preparingSteps = preparingSteps;
    }
}
