package com.optout.optout.external.api.upc;

import com.optout.optout.external.api.ExternalApiProperties;
import com.optout.optout.external.api.ExternalProductApi;
import com.optout.optout.product.JPAProductRepository;
import com.optout.optout.product.Product;
import com.optout.optout.product.ProductAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.NoSuchElementException;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class UpcApi implements ExternalProductApi {

    private final ExternalApiProperties externalApiProperties;
    private final ProductAdapter productAdapter;
    private final JPAProductRepository productRepository;

    //TODO: Make this non blocking
    //Maybe extract it out to a microservice

     public Product getProductByBarcode(String productId){
        String uri = externalApiProperties.upc().url() + productId;
        WebClient.Builder builder= WebClient.builder();
         return builder.build()
                .get()
                .uri(uri)
                .header("Authorization", "Bearer " + externalApiProperties.upc().key())
                .retrieve()
                .bodyToMono(UpcResponse.class)
                 .map(this::validateUpcResponse)
                 .map(productAdapter::convertToProduct)
                 .map(productRepository::save)
                .block();
     }

     private UpcResponse validateUpcResponse(UpcResponse upcResponse) {
         if (!Objects.requireNonNull(upcResponse).success()) {
             throw new NoSuchElementException();
         }
         return upcResponse;
     }
}
