package com.app.recipe.service;

import com.app.recipe.model.Step;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Service
public class StepService {
    private LinkedList<Step> steps = new LinkedList<>();
    private Integer id;

    public void addStep(Step step) {
        steps.add(id, step);
    }

    public Step getStep(Integer id) {
        return steps.get(id);
    }
}
