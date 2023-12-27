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
        Product product = new Product();
        setValidatedManufacturer(product, upcResponse);
        product.setBrand(upcResponse.brand());
        product.setName(upcResponse.title());
        product.setBarcode(upcResponse.barcode());
        return product;
    }

    private void setValidatedManufacturer(Product product, UpcResponse upcResponse) {
        String manufacturerName = upcResponse.manufacturer();
        Manufacturer manufacturer = manufacturerService.getManufacturerByName(manufacturerName);
        product.setManufacturer(Objects.requireNonNullElseGet(manufacturer, () -> new Manufacturer(new ManufacturerRequest("N/A"))));
    }

}