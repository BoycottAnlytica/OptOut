package com.optout.optout.company;

import com.optout.optout.product.JPAProductRepository;
import com.optout.optout.product.Product;
import com.optout.optout.product.ProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final JPACompanyRepository companyRepository;
    private final JPAProductRepository productRepository;

    public Company getCompanyById(long companyId) {
        return companyRepository.findById(companyId)
                .orElseThrow();
    }

    public Company addCompany(CompanyRequest company) {
        var companyToAdd = new Company(company);
        return companyRepository.save(companyToAdd);
    }

    public Product addProductToCompany(long companyId, ProductRequest product) {
        var productToAdd = new Product(product);
        return companyRepository.findById(companyId)
                .map(productToAdd::setCompany)
                .map(productRepository::save)
                .orElseThrow();
    }
}
