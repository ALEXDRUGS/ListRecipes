package com.app.recipe.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.LinkedList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {
    private String name;
    private Integer preparingTime;
    private String measureUnit;
    private LinkedList<Ingredient> ingredients;
    private LinkedList<String> steps;

    @Override
    public String toString() {
        return "Рецепт: " + name + "\n" + " Время приготовления: " + preparingTime +
                " " + measureUnit + "\n" +
                " Ингредиенты: " + ingredients + "\n" +
                ". Способ приготовления: " + steps;
    }
}
