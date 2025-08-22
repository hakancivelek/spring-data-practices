package com.hakancivelek.spring.data.project.pageAndSlice;

import com.hakancivelek.spring.data.project.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.save(product);
    }

    @GetMapping
    public Iterable<Product> getAll() {
        return productService.findAll();
    }

    @GetMapping("/search")
    public Page<Product> searchByName(
            @RequestParam String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return productService.searchByName(name, pageable);
    }

    @GetMapping("/price")
    public Slice<Product> filterByPrice(
            @RequestParam Double min,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return productService.findByPriceGreaterThanEqual(min, pageable);
    }

    @PutMapping("/{id}")
    public Product updateProduct(
            @PathVariable Long id,
            @RequestBody Product updatedProduct) {
        return productService.updateProduct(id, updatedProduct.getName(), updatedProduct.getPrice());
    }
}
