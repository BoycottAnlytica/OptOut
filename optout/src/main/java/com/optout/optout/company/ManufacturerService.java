package com.optout.optout.company;

import com.optout.optout.product.JPAProductRepository;
import com.optout.optout.product.Product;
import com.optout.optout.product.ProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ManufacturerService {

    private final JPAManufacturerRepository manufacturerRepository;
    private final JPAProductRepository productRepository;

    public Manufacturer getManufacturerById(String manufacturerId) {
        return manufacturerRepository.findById(manufacturerId)
                .orElseThrow();
    }

    public Manufacturer getManufacturerByName(String manufacturerName) {
        return manufacturerRepository.findByName(manufacturerName)
                .orElse(createManufacturer(new ManufacturerRequest(manufacturerName)));
    }

    public Manufacturer createManufacturer(ManufacturerRequest company) {
        var  manufacturerToAdd = new Manufacturer(company);
        return manufacturerRepository.save(manufacturerToAdd);
    }

    public Product addProductToManufacturer(String manufacturerId, ProductRequest product) {
        var productToAdd = new Product(product);
        var company =  manufacturerRepository.findById(manufacturerId).orElseThrow();
        productToAdd.setManufacturer(company);
        return productRepository.save(productToAdd);
    }
}
