package com.app.recipe.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping
    public String helloWorld() {
        return "Приложение запущено";
    }

    @GetMapping("path/to/info")
    public String info() {
        String studentsName = "Student's name: Alex";
        String projectName = "Project name: Recipes";
        String creationDate = "Date of creation: 15.12.2022";
        String description = "This app works like a book of recipes";
        return studentsName + " " + projectName + " " + creationDate + " " + description;
    }
}

