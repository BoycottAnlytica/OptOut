package com.optout.optout.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.optout.optout.company.Company;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private String id;

    @ManyToOne
    @JoinColumn(name = "company_id")
    @JsonIgnoreProperties(value = "product")
    private Manufacturer manufacturer;
    private String brand;
    private String name;
    @Column(nullable = false)
    private String barcode;

    public Product(ProductRequest product) {
        this.name = product.name();
        this.barcode = product.barcode();
    }
}
