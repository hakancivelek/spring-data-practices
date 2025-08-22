package com.hakancivelek.spring.data.project.projections;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class ProjectionProductController {
    private final ProjectionProductService projectionProductService;

    public ProjectionProductController(ProjectionProductService projectionProductService) {
        this.projectionProductService = projectionProductService;
    }

    @GetMapping("/product-summaries")
    public Page<ProductSummary> getProductSummaries(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        return projectionProductService.getAllProductSummaries(pageable);
    }
}
