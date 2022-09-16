package com.example.autsoftjavainterview.services;

import com.example.autsoftjavainterview.dao.CategoryRepo;
import com.example.autsoftjavainterview.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private static CategoryRepo categoryRepo;

    @Autowired
    public CategoryService(CategoryRepo categoryRepo) {
        CategoryService.categoryRepo = categoryRepo;
    }

    public static void saveCategory(Category category) {
        categoryRepo.save(category);
    }

    public static void deleteCategory(Category category) {
        categoryRepo.delete(category);
    }

    public static List<Category> getAll() {
        return categoryRepo.findAll();
    }

    public static Category getByName(String name) {
        List<Category> categories = getAll();

        for (Category category : categories) {
            if (category.getName().equals(name))
                return category;
        }

        return null;
    }

    public static Category getById(Long id) {
        List<Category> categories = getAll();

        for (Category category : categories) {
            if (category.getId() == id)
                return category;
        }

        return null;
    }
}
