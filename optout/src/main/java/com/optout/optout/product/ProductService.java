package com.optout.optout.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final JPAProductRepository productRepository;

    public Product getProductById(long productId) {
        return productRepository.findById(productId)
                .orElseThrow();
    }
}
