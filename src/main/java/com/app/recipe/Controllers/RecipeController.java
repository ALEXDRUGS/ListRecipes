package com.app.recipe.Controllers;

import com.app.recipe.model.Recipe;
import com.app.recipe.service.RecipeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recipe")

public class RecipeController {

    @PostMapping

    public void addRecipe(@RequestBody Recipe recipe) {
        RecipeService.addRecipe(recipe);
    }

    @GetMapping("{id}")

    public Recipe getRecipe(Integer id) {
        return RecipeService.getRecipe(id);
    }
}
