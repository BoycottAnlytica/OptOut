package com.optout.optout.product;

import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class ProductService {
    @Value("${UPC_DATABASE_DEMO}")
    private String BearerToken;
    private final JPAProductRepository productRepository;

    public Product getProductById(String productId) {
        return productRepository.findById(productId)
                .orElse(upcApi.getProductByBarcode(productId));
    }

}
