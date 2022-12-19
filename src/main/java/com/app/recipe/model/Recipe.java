package com.app.recipe.model;

import java.util.LinkedList;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Recipe {
    private String nameRecipe;
    private Integer preparingTime;
    private LinkedList<Ingredient> ingredients;
    private LinkedList<String> preparingSteps;
}
