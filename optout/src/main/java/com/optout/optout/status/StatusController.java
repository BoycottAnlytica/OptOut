package com.optout.optout.status;

import com.optout.optout.product.Product;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;
@RequestMapping("api/v1/status")
@RestController
public class StatusController {

    @ResponseStatus(OK)
    @GetMapping
    public String getStatus(){
        return "UP AND RUNNING";
    }

}


