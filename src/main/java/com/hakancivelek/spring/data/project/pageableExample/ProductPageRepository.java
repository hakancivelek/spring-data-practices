package com.hakancivelek.spring.data.project.pageableExample;

import com.hakancivelek.spring.data.project.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductPageRepository extends JpaRepository<Product, Long> {
    Page<Product> findByNameContainingIgnoreCase(String name, Pageable pageable);

    Slice<Product> findByPriceGreaterThanEqual(Double min, Pageable pageable);
}
