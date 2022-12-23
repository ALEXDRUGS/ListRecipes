package com.app.recipe.Controllers;

import com.app.recipe.model.Recipe;
import com.app.recipe.service.RecipeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recipe")

public class RecipeController {
    private RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping

    public void addRecipe(@RequestBody Recipe recipe) {
        recipeService.addRecipe(recipe);
    }

    @GetMapping("{id}")

    public Recipe getRecipe(@PathVariable Integer id) {
        return recipeService.getRecipe(id);
    }
}
