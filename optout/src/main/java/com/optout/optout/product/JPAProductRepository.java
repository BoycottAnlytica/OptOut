package com.optout.optout.product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JPAProductRepository extends JpaRepository<Product, Long> {
}