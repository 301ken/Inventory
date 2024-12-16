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
@Transactional // Ensures database transactions are properly managed
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    /**
     * Retrieve all products.
     * @return a list of all products.
     */
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    /**
     * Retrieve a product by its ID.
     * @param id the product ID.
     * @return the product entity.
     */
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
    }

    /**
     * Create a new product.
     * @param productDTO the DTO containing product details.
     * @return the created product entity.
     */
    public Product createProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());

        // Set category if provided
        if (productDTO.getCategoryId() != null) {
            Category category = categoryRepository.findById(productDTO.getCategoryId())
                    .orElseThrow(() -> new ResourceNotFoundException("Category not found for id: " + productDTO.getCategoryId()));
            product.setCategory(category);
        }

        return productRepository.save(product);
    }

    /**
     * Update an existing product.
     * @param id the product ID to update.
     * @param productDTO the DTO containing updated product details.
     * @return the updated product entity.
     */
    public Product updateProduct(Long id, ProductDTO productDTO) {
        Product product = getProductById(id);

        // Update name if provided
        if (productDTO.getName() != null) {
            product.setName(productDTO.getName());
        }

        // Update price if provided
        if (productDTO.getPrice() != 0) { // Assuming 0 is not a valid price
            product.setPrice(productDTO.getPrice());
        }

        // Update category if provided
        if (productDTO.getCategoryId() != null) {
            Category category = categoryRepository.findById(productDTO.getCategoryId())
                    .orElseThrow(() -> new ResourceNotFoundException("Category not found for id: " + productDTO.getCategoryId()));
            product.setCategory(category);
        }

        return productRepository.save(product);
    }

    /**
     * Delete a product by its ID.
     * @param id the product ID.
     */
    public void deleteProduct(Long id) {
        Product product = getProductById(id);
        productRepository.delete(product);
    }
}
