package com.optout.optout.product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JPAProductRepository extends JpaRepository<Product, String> {
    Optional<Product> findByBarcode(String productBarcode);
}
