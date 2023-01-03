package com.app.recipe.controllers;

import com.app.recipe.service.impl.FileServiceImpl;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@RestController
@RequestMapping("/files")
public class FileController {
    private final FileServiceImpl fileServiceImpl;

    public FileController(FileServiceImpl fileServiceImpl) {
        this.fileServiceImpl = fileServiceImpl;
    }

    @GetMapping("/export/recipe")
    public ResponseEntity<InputStreamResource> downloadRecipeDataFile() throws FileNotFoundException {
        File file = fileServiceImpl.getRecipeDataFile();
        if (file.exists()) {
            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .contentLength(file.length())
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"Recipes.json\"")
                    .body(resource);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/export/ingredients")
    public ResponseEntity<InputStreamResource> downloadIngDataFile() throws FileNotFoundException {
        File file = fileServiceImpl.getIngDataFile();
        if (file.exists()) {
            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .contentLength(file.length())
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"Ingredients.json\"")
                    .body(resource);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping(value = "/import/recipe", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> uploadRecipeDataFile(@RequestParam MultipartFile multipartFile) {
        fileServiceImpl.cleanRecipeDataFile();
        File file = fileServiceImpl.getRecipeDataFile();
        try (FileOutputStream fos = new FileOutputStream(file)){
            IOUtils.copy(multipartFile.getInputStream(), fos);
            return ResponseEntity.ok().build();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @PostMapping(value = "/import/ingredients", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> uploadIngDataFile(@RequestParam MultipartFile multipartFile) {
        fileServiceImpl.cleanIngDataFile();
        File file = fileServiceImpl.getIngDataFile();
        try (FileOutputStream fos = new FileOutputStream(file)){
            IOUtils.copy(multipartFile.getInputStream(), fos);
            return ResponseEntity.ok().build();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
