package com.app.recipe.Controllers;

import com.app.recipe.model.Ingredient;
import com.app.recipe.service.IngredientService;
import com.app.recipe.service.RecipeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController


public class IngredientController {
    @PostMapping("/ingredients")

    public void addIngredient(@RequestBody Ingredient ingredient) {
        IngredientService.addIngredient(ingredient);
    }

    @GetMapping("{id}")

    public Ingredient getIngredient(Integer id) {
        return IngredientService.getIngredient(id);
    }
}
