package com.optout.optout.product;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.optout.optout.company.Manufacturer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;


@Getter
@Setter
@Entity
@NoArgsConstructor
@Builder
public class Product {

    @Id
    @Column(nullable = false)
    private String barcode;

    @ManyToOne
    @JoinColumn(name = "company_id")
    @JsonIgnoreProperties(value = "product")
    private Manufacturer manufacturer;
    private String brand;
    private String name;

    public Product(ProductRequest product) {
        this.name = product.name();
        this.barcode = product.barcode();
    }
}
