package com.app.recipe.controllers;

import com.app.recipe.model.Recipe;
import com.app.recipe.service.impl.RecipeServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recipe")

public class RecipeController {
    private final RecipeServiceImpl recipeServiceImpl;

    public RecipeController(RecipeServiceImpl recipeServiceImpl) {
        this.recipeServiceImpl = recipeServiceImpl;
    }

    @Operation(description = "Recipe has been added")
    @PostMapping

    public ResponseEntity<Recipe> addRecipe(@RequestBody @NotNull Recipe recipe) {
        ResponseEntity<Recipe> result;
        if (StringUtils.isBlank(recipe.getName())) {
            result = ResponseEntity.badRequest().build();
        } else {
            result = ResponseEntity.ok(recipeServiceImpl.addRecipe(recipe));
        }
        return result;
    }

    @GetMapping("/{id}")
    public Recipe getRecipe(@PathVariable("id") Integer id) {
        return recipeServiceImpl.getRecipe(id);
    }

    @PutMapping("/{id}")
    public Recipe updateRecipe(@PathVariable("id") Integer id, @RequestBody Recipe recipe) {
        return recipeServiceImpl.updateRecipe(id, recipe);
    }

    @DeleteMapping("/{id}")
    public void deleteRecipe(@PathVariable("id") Integer id) {
        recipeServiceImpl.deleteRecipe(id);
    }
}
