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
    private LinkedList<Step> steps;
    private Integer id;


    @Override
    public String toString() {
        return "Рецепт: " + name + ", время приготовления: " + preparingTime +
                " " + measureUnit +
                ", Ингредиенты: " + ingredients +
                ". Способ приготовления: " + steps;
    }
}
