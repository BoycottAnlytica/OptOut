package com.optout.optout.status;

import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;
@RequestMapping("api/v1/status")
@RestController
@CrossOrigin(value = "*")
public class StatusController {

    @ResponseStatus(OK)
    @GetMapping
    public Status getStatus(){
        return new Status("UP AND RUNNING");
    }

}


