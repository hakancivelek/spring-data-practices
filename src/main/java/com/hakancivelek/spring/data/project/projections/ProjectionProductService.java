package com.hakancivelek.spring.data.project.projections;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProjectionProductService {
    private final ProductSummaryRepository repository;

    public ProjectionProductService(ProductSummaryRepository repository) {
        this.repository = repository;
    }

    public Page<ProductSummary> getAllProductSummaries(Pageable pageable) {
        return repository.findAllProjectedBy(pageable);
    }
}
