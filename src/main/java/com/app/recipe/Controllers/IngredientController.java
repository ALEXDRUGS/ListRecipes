package com.app.recipe.Controllers;

import com.app.recipe.model.Ingredient;
import com.app.recipe.service.IngredientService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ingredients")

public class IngredientController {
    @PostMapping

    public void addIngredient(@RequestBody Ingredient ingredient) {
        IngredientService.addIngredient(ingredient);
    }

    @GetMapping("{id}")

    public Ingredient getIngredient(Integer id) {
        return IngredientService.getIngredient(id);
    }
}
