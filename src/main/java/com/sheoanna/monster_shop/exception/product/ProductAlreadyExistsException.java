package com.sheoanna.monster_shop.exception.product;

import com.sheoanna.monster_shop.exception.CustomException;

public class ProductAlreadyExistsException extends CustomException {
    public ProductAlreadyExistsException(String message) {
        super(message);
    }

    public ProductAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
