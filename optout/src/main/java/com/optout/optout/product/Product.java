package com.optout.optout.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.optout.optout.company.Company;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private String Id;

    @ManyToOne
    @JoinColumn(name = "company_id")
    @JsonIgnoreProperties(value = "product")
    private Company company;
    private String name;
    @Column(nullable = false)
    private String barcode;

    public Product(ProductRequest product) {
        this.name = product.name();
        this.barcode = product.barcode();
    }

    public Product setCompany(Company company){
        this.company = company;
        return this;
    }

}
