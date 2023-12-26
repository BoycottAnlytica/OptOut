package com.optout.optout.product;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.optout.optout.company.Manufacturer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
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
