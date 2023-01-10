package com.app.recipe.controllers;

import com.app.recipe.model.Ingredient;
import com.app.recipe.service.IngredientService;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {
    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @PostMapping
    public ResponseEntity<Ingredient> addIngredient(@RequestBody @NotNull Ingredient ingredient) throws IOException {
        ResponseEntity<Ingredient> result;
        if (StringUtils.isBlank(ingredient.getNameIngredient())) {
            result = ResponseEntity.badRequest().build();
        } else {
            result = ResponseEntity.ok(ingredientService.addIngredient(ingredient));
        }
        return result;
    }

    @GetMapping("/{id}")
    public Ingredient getIngredient(@PathVariable("id") Integer id) {
        return ingredientService.getIngredient(id);
    }

    @PutMapping("/{id}")
    public Ingredient updateIngredient(@PathVariable Integer id, @RequestBody Ingredient ingredient) throws IOException {
        return ingredientService.updateIngredient(id, ingredient);
    }

    @DeleteMapping("/{id}")
    public void deleteIngredient(@PathVariable("id") Integer id) {
        ingredientService.deleteIngredient(id);
    }
}
