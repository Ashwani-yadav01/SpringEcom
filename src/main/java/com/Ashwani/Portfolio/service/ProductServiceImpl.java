package com.Ashwani.Portfolio.service;

import com.Ashwani.Portfolio.exceptions.ResourceNotFoundException;
import com.Ashwani.Portfolio.model.Category;
import com.Ashwani.Portfolio.model.Product;
import com.Ashwani.Portfolio.payload.ProductDTO;
import com.Ashwani.Portfolio.payload.ProductResponse;
import com.Ashwani.Portfolio.repositories.CategoryRepository;
import com.Ashwani.Portfolio.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @Override
    public ProductDTO addProduct(Long categoryId, Product product) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));
        product.setImage("default.png");
        product.setCategory(category);
        double specialPrice = product.getPrice() - (product.getDiscount() * 0.01) * product.getPrice();
        product.setSpecialPrice(specialPrice);
        Product savedProduct = productRepository.save(product);

        return modelMapper.map(savedProduct, ProductDTO.class);
    }

    @Override
    public ProductResponse getAllProducts() {
        List<ProductDTO> productDTOS = new ArrayList<>();
        for (Product product : productRepository.findAll()) {
            productDTOS.add(modelMapper.map(product, ProductDTO.class));
        }
        ProductResponse productResponse = new ProductResponse();
        productResponse.setContent(productDTOS);
        return productResponse;
    }
}
