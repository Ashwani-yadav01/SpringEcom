package com.Ashwani.Portfolio.service;

import com.Ashwani.Portfolio.model.Product;
import com.Ashwani.Portfolio.payload.ProductDTO;
import com.Ashwani.Portfolio.payload.ProductResponse;

public interface ProductService {
    ProductDTO addProduct(Long categoryId, Product product);

    ProductResponse getAllProducts();
}
