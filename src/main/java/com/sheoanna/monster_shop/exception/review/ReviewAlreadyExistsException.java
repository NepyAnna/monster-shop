package com.sheoanna.monster_shop.exception.review;

import com.sheoanna.monster_shop.exception.CustomException;

public class ReviewAlreadyExistsException extends CustomException {
    public ReviewAlreadyExistsException(String message) {
        super(message);
    }

    public ReviewAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
