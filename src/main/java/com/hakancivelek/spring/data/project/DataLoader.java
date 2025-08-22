package com.hakancivelek.spring.data.project;

import com.hakancivelek.spring.data.project.pageableExample.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
public class DataLoader implements CommandLineRunner {
    private final ProductService productService;

    public DataLoader(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void run(String... args) {
        if (!productService.findAll().iterator().hasNext()) {
            IntStream.rangeClosed(1, 50).forEach(i ->
                    productService.save(new Product("Product " + i, i * 10.0))
            );
            System.out.println("50 ürün eklendi 🚀");
        }
    }
}
