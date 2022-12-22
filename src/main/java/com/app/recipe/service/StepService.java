package com.app.recipe.service;

import com.app.recipe.model.Step;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Service
public class StepService {
    private static final LinkedList<Step> STEPS = new LinkedList<>();
    private static Integer id;

    public static void addStep(Step step) {
        STEPS.add(id, step);
    }

    public static Step getStep(Integer id) {
        return STEPS.get(id);
    }
}
