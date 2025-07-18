package com.Ashwani.Portfolio.service;

import com.Ashwani.Portfolio.model.Category;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

    private List<Category> categories = new ArrayList<>();
    private  Long nextId= 1L;

    @Override
    public List<Category> getAllCategories() {
        return categories;
    }

    @Override
    public void createCategory(Category category) {
        category.setCategoryId(nextId++);
         categories.add(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {
        Category category = categories.stream().
                filter(c->c.getCategoryId().equals(categoryId))
                .findFirst().orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Resource not found"));
        categories.remove(category);
        return "deleted successfully ";
    }


//    public Category updateCategory(Category category,Long categoryId) {
//        Optional<Category> optionalCategory = categories.stream().
//                filter(c->c.getCategoryId().equals(categoryId)).findFirst();
//
//        if (optionalCategory.isPresent()){
//            Category existinnCategory= optionalCategory.get();
//            existinnCategory.setCategoryName(category.getCategoryName());
//            return  existinnCategory;
//        }else {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Category not found");
//        }
//
//    }

    // More optimized version
    @Override
    public Category updateCategory(Category category,Long categoryId) {


        Optional<Category> optionalCategory = categories.stream().
                filter(c->c.getCategoryId().equals(categoryId)).findFirst();

        if (optionalCategory.isPresent()){
            Category existinnCategory= optionalCategory.get();
            existinnCategory.setCategoryName(category.getCategoryName());
            return  existinnCategory;
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Category not found");
        }

    }
}
