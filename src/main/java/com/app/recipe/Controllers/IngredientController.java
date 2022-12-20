package com.app.recipe.Controllers;

import com.app.recipe.model.Ingredient;
import com.app.recipe.service.impl.ServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController


public class IngredientController {
    @PostMapping("/ingredients")

    public void addIngredient(Ingredient ingredient) {
        ServiceImpl.addIngredient(ingredient);
    }

    @GetMapping("/ingredients")

    public String getRecipe() {
        return ServiceImpl.getIngredient();
    }
}
