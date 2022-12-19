package com.app.recipe.Controllers;

import com.app.recipe.model.Ingredient;
import com.app.recipe.service.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.Map;

@RestController

public class IngredientController {

    @PostMapping("/ingredients")

    public void addIngredient(LinkedList<Ingredient> ingredients) {
        Service service = new Service();
        service.addIngredient(ingredients);
    }

    @GetMapping("/ingredients")

    public String getIngredient() {
        Service service = new Service();
        return service.getIngredient();
    }
}
