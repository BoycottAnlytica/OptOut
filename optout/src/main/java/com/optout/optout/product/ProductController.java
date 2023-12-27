package com.optout.optout.product;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("{productId}")
    @ResponseStatus(OK)
    public Product getProduct(@PathVariable String productId){
        return productService.getProductByBarcode(productId);
    }




}

