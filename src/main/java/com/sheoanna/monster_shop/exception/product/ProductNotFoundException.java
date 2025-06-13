package com.sheoanna.monster_shop.exception.product;

import com.sheoanna.monster_shop.exception.CustomException;

public class ProductNotFoundException extends CustomException {
    public ProductNotFoundException(String message) {
        super(message);
    }

    public ProductNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
