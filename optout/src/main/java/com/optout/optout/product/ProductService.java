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

//    public Product getProductById(String productId) {
//        return productRepository.findById(productId)
//                .orElseThrow();
//    }

    public String getProductById(String productId) {
        return getExternalProduct(productId);
    }

    private String getExternalProduct(String productId){
        String url = "https://api.upcdatabase.org/product/"+productId;
        WebClient.Builder builder= WebClient.builder();
        String product= builder.build()
                .get()
                .uri(url)
                .header("Authorization", "Bearer " +BearerToken)
                .retrieve()
                .bodyToMono(String.class)
                .block();
        System.out.println(product);
        return product;

    }



}
