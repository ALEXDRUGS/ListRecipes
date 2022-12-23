package com.app.recipe.Controllers;

import com.app.recipe.model.Step;
import com.app.recipe.service.StepService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/steps")

public class StepController {
    @PostMapping

    public void addStep(@RequestBody Step step) {
        addStep(step);
    }

    @GetMapping("{id}")

    public Step getStep(Integer id) {
        return getStep(id);
    }
}
