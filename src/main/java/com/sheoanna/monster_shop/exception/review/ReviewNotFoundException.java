package com.sheoanna.monster_shop.exception.review;

import com.sheoanna.monster_shop.exception.CustomException;

public class ReviewNotFoundException extends CustomException {
    public ReviewNotFoundException(String message) {
        super(message);
    }

    public ReviewNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
