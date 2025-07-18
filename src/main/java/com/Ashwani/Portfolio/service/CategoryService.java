package com.Ashwani.Portfolio.service;

import com.Ashwani.Portfolio.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    void createCategory(Category category);
    String deleteCategory(Long id);
     Category updateCategory(Category category,Long categoryId);
}
