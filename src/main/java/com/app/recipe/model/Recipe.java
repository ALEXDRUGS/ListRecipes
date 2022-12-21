package com.app.recipe.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.LinkedList;

@Data
@AllArgsConstructor

public class Recipe {
    private String name;
    private Integer preparingTime;
    private String measureUnit;
    private LinkedList<Ingredient> ingredients;
    private LinkedList<String> preparingSteps;
}
