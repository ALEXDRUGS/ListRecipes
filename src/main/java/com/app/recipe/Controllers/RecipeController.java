package com.app.recipe.Controllers;

import com.app.recipe.model.Recipe;
import com.app.recipe.service.RecipeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class RecipeController {

    @PostMapping("/recipe")

    public void addRecipe(@RequestBody Recipe recipe) {
        RecipeService.addRecipe(recipe);
    }

    @GetMapping("{id}")

    public Recipe getRecipe(Integer id) {
        return RecipeService.getRecipe(id);
    }
}
