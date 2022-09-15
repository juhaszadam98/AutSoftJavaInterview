package com.example.autsoftjavainterview.controllers;

import com.example.autsoftjavainterview.model.Category;
import com.example.autsoftjavainterview.services.CategoryService;
import com.example.autsoftjavainterview.services.EntryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getAll() {
        List<Category> categories = CategoryService.getAll();

        if (categories.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return ResponseEntity.ok(categories);
    }

    @GetMapping("/category/{name}")
    public  ResponseEntity<Category> getByName(@PathVariable String name) {
        Category category = CategoryService.getByName(name);

        if (category == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return ResponseEntity.ok(category);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Category> getById(@PathVariable Long id) {
        Category category = CategoryService.getById(id);

        if (category == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return ResponseEntity.ok(category);
    }

    @PostMapping("/category")
    public ResponseEntity<Category> newCategory(@RequestBody Category category) {
        try {
            CategoryService.saveCategory(category);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/category/{name}")
    public ResponseEntity<Category> deleteByName(@PathVariable String name) {
        Category category = CategoryService.getByName(name);

        if (category == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        CategoryService.deleteCategory(category);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
