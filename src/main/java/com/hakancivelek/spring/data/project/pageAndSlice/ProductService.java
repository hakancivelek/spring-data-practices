package com.hakancivelek.spring.data.project.pageAndSlice;

import com.hakancivelek.spring.data.project.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductPageRepository productRepo;

    public ProductService(ProductPageRepository productRepo) {
        this.productRepo = productRepo;
    }

    public Product save(Product product) {
        return productRepo.save(product);
    }

    public Page<Product> searchByName(String name, Pageable pageable) {
        return productRepo.findByNameContainingIgnoreCase(name, pageable);
    }

    public Slice<Product> findByPriceGreaterThanEqual(Double min, Pageable pageable) {
        return productRepo.findByPriceGreaterThanEqual(min, pageable);
    }

    public Iterable<Product> findAll() {
        return productRepo.findAll();
    }

    public Product updateProduct(Long id, String newName, Double newPrice) {
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        product.setName(newName);
        product.setPrice(newPrice);
        return productRepo.save(product);
    }

}