package com.optout.optout.company;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JPAManufacturerRepository extends JpaRepository<Manufacturer, String> {
    Optional<Manufacturer> findByName(String string);

}
