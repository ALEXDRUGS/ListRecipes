package com.app.recipe.Controllers;

import com.app.recipe.model.Recipe;
import com.app.recipe.service.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController

public class RecipeController {
//

    @PostMapping("/recipe")

    public void addRecipe(Recipe recipe) {
        Service.addRecipe(recipe);
    }

    @GetMapping("/recipe")

    public Recipe getRecipe() {
        return Service.getRecipe();
    }
}
