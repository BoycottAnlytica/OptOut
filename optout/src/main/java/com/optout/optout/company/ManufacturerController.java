package com.optout.optout.company;

import com.optout.optout.product.Product;
import com.optout.optout.product.ProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("api/v1/manufacturers")
@RequiredArgsConstructor
public class ManufacturerController {

    private final ManufacturerService manufacturerService;

    @GetMapping("{manufacturerId}")
    @ResponseStatus(OK)
    public Manufacturer getCompany(@PathVariable String manufacturerId){
        return manufacturerService.getManufacturerById(manufacturerId);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Manufacturer createCompany(@RequestBody ManufacturerRequest company){
        return manufacturerService.createManufacturer(company);
    }

    @PostMapping("{manufacturerId}")
    @ResponseStatus(CREATED)
    public Product addProductToCompany(@PathVariable String manufacturerId, @RequestBody ProductRequest product){
        return manufacturerService.addProductToManufacturer(manufacturerId, product);
    }
}
