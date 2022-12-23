package com.app.recipe.Controllers;

import com.app.recipe.model.Recipe;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recipe")

public class RecipeController {

    @PostMapping

    public void addRecipe(@RequestBody Recipe recipe) {
        addRecipe(recipe);
    }

    @GetMapping("{id}")

    public Recipe getRecipe(Integer id) {
        return getRecipe(id);
    }
}
