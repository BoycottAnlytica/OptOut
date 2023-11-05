package com.optout.optout.model;

import com.optout.optout.model.Company;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Product {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id", insertable=false, updatable=false)
    private Company company;

}
