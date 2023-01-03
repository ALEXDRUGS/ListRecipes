package com.app.recipe.controllers;

import com.app.recipe.model.Ingredient;
import com.app.recipe.service.impl.IngredientServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {
    private final IngredientServiceImpl ingredientServiceImpl;

    public IngredientController(IngredientServiceImpl ingredientServiceImpl) {
        this.ingredientServiceImpl = ingredientServiceImpl;
    }

    @PostMapping
    public ResponseEntity<Ingredient> addIngredient(@RequestBody @NotNull Ingredient ingredient) {
        ResponseEntity<Ingredient> result;
        if (StringUtils.isBlank(ingredient.getNameIngredient())) {
            result = ResponseEntity.badRequest().build();
        } else {
            result = ResponseEntity.ok(ingredientServiceImpl.addIngredient(ingredient));
        }
        return result;
    }

    @GetMapping("/{id}")
    public Ingredient getIngredient(@PathVariable("id") Integer id) {
        return ingredientServiceImpl.getIngredient(id);
    }

    @PutMapping("/{id}")
    public Ingredient updateIngredient(@PathVariable Integer id, @RequestBody Ingredient ingredient) {
        return ingredientServiceImpl.updateIngredient(id, ingredient);
    }

    @DeleteMapping("/{id}")
    public void deleteIngredient(@PathVariable("id") Integer id) {
        ingredientServiceImpl.deleteIngredient(id);
    }
}
