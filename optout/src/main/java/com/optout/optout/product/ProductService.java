package com.optout.optout.product;

import com.optout.optout.external.api.upc.UpcApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final JPAProductRepository productRepository;
    private final UpcApi upcApi;

    public Product getProductByBarcode(String productBarcode) {
        return productRepository.findByBarcode(productBarcode)
                .orElseGet(upcProductSupplier(productBarcode));
    }

    private Supplier<Product> upcProductSupplier(String productBarcode) {
        return () -> (upcApi.getProductByBarcode(productBarcode));
    }

}
