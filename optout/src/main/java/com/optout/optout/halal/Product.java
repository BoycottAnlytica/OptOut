package com.optout.optout.halal;

import com.optout.optout.stance.Company;
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
