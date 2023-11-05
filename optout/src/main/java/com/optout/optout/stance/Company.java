package com.optout.optout.stance;

import com.optout.optout.halal.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private Stance stance;
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Product> product;

    public enum Stance {
        PRO_PALESTINE,
        UNKNOWN,
        ANTI_PALESTINE
    }
}
