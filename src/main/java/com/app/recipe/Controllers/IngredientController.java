package com.app.recipe.Controllers;

import com.app.recipe.model.Ingredient;
import com.app.recipe.model.Recipe;
import com.app.recipe.service.IngredientService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ingredients")

public class IngredientController {
    private IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @PostMapping

    public void addIngredient(@RequestBody Ingredient ingredient) {
        ingredientService.addIngredient(ingredient);
    }

    @GetMapping("{id}")

    public Ingredient getIngredient(@PathVariable Integer id) {
        return ingredientService.getIngredient(id);
    }
    @PutMapping
    public Ingredient updateIngredient(@RequestBody Ingredient ingredient) {
        return ingredientService.updateIngredient(ingredient.getId(), ingredient);
    }

    @DeleteMapping(value = "/ingredients/{id}")
    public void deleteIngredient(@PathVariable Integer id) {
        ingredientService.deleteIngredient(id);
    }
}
