package com.app.recipe.Controllers;

import com.app.recipe.model.Step;
import com.app.recipe.service.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class StepController {
    @PostMapping("/steps")

    public void addStep(@RequestBody Step step) {
        Service.addStep(step);
    }

    @GetMapping("/steps")

    public String getStep() {
        return Service.getStep();
    }
}
