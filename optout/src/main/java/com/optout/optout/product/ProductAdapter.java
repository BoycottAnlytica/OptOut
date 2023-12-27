package com.optout.optout.product;

import com.optout.optout.company.Manufacturer;
import com.optout.optout.company.ManufacturerRequest;
import com.optout.optout.company.ManufacturerService;
import com.optout.optout.external.api.upc.UpcResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;


@Component
@RequiredArgsConstructor
public class ProductAdapter {

    private final ManufacturerService manufacturerService;

    public Product convertToProduct(UpcResponse upcResponse) {
        var product = Product.builder()
                .barcode(upcResponse.barcode())
                .brand(upcResponse.brand())
                .name(upcResponse.title())
                .build();
        setValidatedManufacturer(product, upcResponse);
        return product;
    }

    private void setValidatedManufacturer(Product product, UpcResponse upcResponse) {
        Manufacturer manufacturer = manufacturerService.getManufacturerByName(upcResponse.manufacturer());
        product.setManufacturer(Objects.requireNonNullElseGet(manufacturer,
                () -> new Manufacturer(new ManufacturerRequest("N/A"))));
    }

}