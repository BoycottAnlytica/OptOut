package com.optout.optout.company;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.optout.optout.product.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
@Table(indexes = @Index(columnList = "name"))
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private long id;
    @Column(nullable = false)
    private String name;
    @OneToMany(mappedBy = "manufacturer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = "manufacturer")
    private final List<Product> product = new ArrayList<>();

    public Manufacturer(ManufacturerRequest company) {
        this.name = company.name();
    }

    public void addProduct(Product product){
        this.product.add(product);
    }
}
