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

    public Manufacturer getCompanyById(String manufacturerId) {
        return manufacturerRepository.findById(manufacturerId)
                .orElseThrow();
    }

    public Manufacturer addCompany(ManufacturerRequest company) {
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
