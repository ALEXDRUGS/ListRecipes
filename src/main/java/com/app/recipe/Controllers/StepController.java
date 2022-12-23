package com.app.recipe.Controllers;

import com.app.recipe.model.Step;
import com.app.recipe.service.StepService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/steps")

public class StepController {
    private StepService stepService;

    public StepController(StepService stepService) {
        this.stepService = stepService;
    }

    @PostMapping

    public void addStep(@RequestBody Step step) {
        stepService.addStep(step);
    }

    @GetMapping("{id}")

    public Step getStep(@PathVariable Integer id) {
        return stepService.getStep(id);
    }
}
