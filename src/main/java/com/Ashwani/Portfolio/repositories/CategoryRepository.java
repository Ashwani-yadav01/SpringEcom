package com.Ashwani.Portfolio.repositories;

import com.Ashwani.Portfolio.model.Category;
import com.Ashwani.Portfolio.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    Category findByCategoryName(String categoryName);
}
