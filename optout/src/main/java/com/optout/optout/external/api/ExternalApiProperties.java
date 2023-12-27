package com.optout.optout.external.api;

import com.optout.optout.external.api.upc.UpcProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "external.api")
public record ExternalApiProperties (

        UpcProperties upc

){}
