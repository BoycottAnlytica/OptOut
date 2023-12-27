package com.optout.optout.external.api.upc;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Map;
import java.util.Objects;

public record UpcResponse (
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        String addedTime,
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        String modifiedTime,
        String title,
        String alias,
        String description,
        String brand,
        String manufacturer,
        String msrp,
        String ASIN,
        String category,
        String categories,
        Map<String, Object> stores,
        String barcode,
        boolean success,
        long timestamp,
        Map<String, Object> images
){

        @Override
        public String manufacturer() {
                if (Objects.equals(manufacturer, "")){
                        return "N/A";
                }
                return manufacturer;
        }
}
