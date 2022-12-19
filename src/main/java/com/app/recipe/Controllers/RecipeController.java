package com.app.recipe.Controllers;

import com.app.recipe.model.Recipe;
import com.app.recipe.service.impl.ServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class RecipeController {
//

    @PostMapping("/recipe")

    public void addRecipe(Recipe recipe) {
        ServiceImpl.addRecipe(recipe);
    }

    @GetMapping("/recipe")

    public Recipe getRecipe() {
        return ServiceImpl.getRecipe();
    }
}
