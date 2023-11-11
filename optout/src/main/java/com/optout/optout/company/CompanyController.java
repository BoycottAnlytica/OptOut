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
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping("{companyId}")
    @ResponseStatus(OK)
    public Company getCompany(@PathVariable long companyId){
        return companyService.getCompanyById(companyId);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Company createCompany(@RequestBody CompanyRequest company){
        return companyService.addCompany(company);
    }

    @PostMapping("{companyId}")
    @ResponseStatus(CREATED)
    public Product addProductToCompany(@PathVariable long companyId, @RequestBody ProductRequest product){
        return companyService.addProductToCompany(companyId, product);
    }
}
