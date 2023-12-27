package com.optout.optout.company;

import com.optout.optout.product.Product;
import com.optout.optout.product.ProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("api/v1/companys")
@RequiredArgsConstructor
public class ManufacturerController {

    private final ManufacturerService manufacturerService;

    @GetMapping("{companyId}")
    @ResponseStatus(OK)
    public Manufacturer getCompany(@PathVariable String companyId){
        return manufacturerService.getCompanyById(companyId);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Manufacturer createCompany(@RequestBody ManufacturerRequest company){
        return manufacturerService.addCompany(company);
    }

    @PostMapping("{companyId}")
    @ResponseStatus(CREATED)
    public Product addProductToCompany(@PathVariable String companyId, @RequestBody ProductRequest product){
        return manufacturerService.addProductToManufacturer(companyId, product);
    }
}
