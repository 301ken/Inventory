package com.example.inventory.service;

import com.example.inventory.dto.ProductDTO;
import com.example.inventory.entity.Category;
import com.example.inventory.entity.Product;
import com.example.inventory.exception.ResourceNotFoundException;
import com.example.inventory.repository.CategoryRepository;
import com.example.inventory.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional 
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
    }

    public Product createProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());

        
        if (productDTO.getCategoryId() != null) {
            Category category = categoryRepository.findById(productDTO.getCategoryId())
                    .orElseThrow(() -> new ResourceNotFoundException("Category not found for id: " + productDTO.getCategoryId()));
            product.setCategory(category);
        }

        return productRepository.save(product);
    }

    public Product updateProduct(Long id, ProductDTO productDTO) {
        Product product = getProductById(id);

        if (productDTO.getName() != null) {
            product.setName(productDTO.getName());
        }

        if (productDTO.getPrice() != 0) { 
            product.setPrice(productDTO.getPrice());
        }

        if (productDTO.getCategoryId() != null) {
            Category category = categoryRepository.findById(productDTO.getCategoryId())
                    .orElseThrow(() -> new ResourceNotFoundException("Category not found for id: " + productDTO.getCategoryId()));
            product.setCategory(category);
        }

        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        Product product = getProductById(id);
        productRepository.delete(product);
    }
}
