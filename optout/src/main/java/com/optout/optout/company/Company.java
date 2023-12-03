package com.optout.optout.company;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.optout.optout.product.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static com.optout.optout.company.Company.Stance.UNKNOWN;


@NoArgsConstructor
@Getter
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private String id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private final Stance stance = UNKNOWN;
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = "company")
    private final List<Product> product = new ArrayList<>();

    public Company(CompanyRequest company) {
        this.name = company.name();
    }

    public enum Stance {
        PRO_PALESTINE,
        UNKNOWN,
        ANTI_PALESTINE
    }

    public void addProduct(Product product){
        this.product.add(product);
    }
}
