package com.app.recipe.Controllers;

import com.app.recipe.model.Ingredient;
import com.app.recipe.model.Recipe;
import com.app.recipe.service.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.Map;

@RestController

public class RecipeController {
//

    @PostMapping("/recipe")

    public void addRecipe(Recipe recipe) {
        Service service = new Service();
        service.addRecipe(recipe);
    }

    @GetMapping("/recipe")

    public String getRecipe() {
        Service service = new Service();
        return service.getRecipe();
    }
}
