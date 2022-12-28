package com.app.recipe.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

@Data
@AllArgsConstructor
public class Recipe {
    private String name;
    private Integer preparingTime;
    private String measureUnit;
    private Map<Integer, Ingredient> ingredients;
    private LinkedList<String> steps;

    @Override
    public String toString() {
        return "Рецепт: " + name + ", время приготовления: " + preparingTime +
                " " + measureUnit +
                ", Ингредиенты: " + ingredients +
                ". Способ приготовления: " + steps;
    }
}
