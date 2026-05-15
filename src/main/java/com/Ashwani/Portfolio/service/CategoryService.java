package com.Ashwani.Portfolio.service;

import com.Ashwani.Portfolio.payload.CategoryDTO;
import com.Ashwani.Portfolio.payload.CategoryResponse;

public interface CategoryService {
    CategoryResponse getAllCategories(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);

    CategoryDTO createCategory(CategoryDTO categoryDTO);

    CategoryDTO deleteCategory(Long id);

    CategoryDTO updateCategory(CategoryDTO categoryDTO, Long categoryId);
}
