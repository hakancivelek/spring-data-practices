package com.hakancivelek.spring.data.project.projections;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.hakancivelek.spring.data.project.Product; // Entity class

public interface ProductSummaryRepository extends JpaRepository<Product, Long> {
    Page<ProductSummary> findAllProjectedBy(Pageable pageable);
}

