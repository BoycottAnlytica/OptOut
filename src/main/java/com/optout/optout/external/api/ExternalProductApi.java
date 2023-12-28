package com.optout.optout.external.api;

import com.optout.optout.product.Product;

@FunctionalInterface
public interface ExternalProductApi {

    Product getProductByBarcode(String barcode);
}
