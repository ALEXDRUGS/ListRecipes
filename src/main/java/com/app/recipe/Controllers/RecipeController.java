package com.app.recipe.controllers;

import com.app.recipe.model.Recipe;
import com.app.recipe.service.RecipeService;
import io.swagger.v3.oas.annotations.Operation;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recipe")

public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @Operation(description = "Recipe has been added")
    @PostMapping

    public ResponseEntity<Recipe> addRecipe(@RequestBody @NotNull Recipe recipe) {
        ResponseEntity<Recipe> result;
        if (StringUtils.isBlank(recipe.getName())) {
            result = ResponseEntity.badRequest().build();
        } else {
            result = ResponseEntity.ok(recipeService.addRecipe(recipe));
        }
        return result;
    }

    @GetMapping("/{id}")
    public Recipe getRecipe(@PathVariable("id") Integer id) {
        return recipeService.getRecipe(id);
    }

    @PutMapping("/{id}")
    public Recipe updateRecipe(@PathVariable("id") Integer id, @RequestBody Recipe recipe) {
        return recipeService.updateRecipe(id, recipe);
    }

    @DeleteMapping("/{id}")
    public void deleteRecipe(@PathVariable("id") Integer id) {
        recipeService.deleteRecipe(id);
    }
}
