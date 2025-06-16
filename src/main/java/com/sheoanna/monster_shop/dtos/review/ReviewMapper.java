package com.sheoanna.monster_shop.dtos.review;

import com.sheoanna.monster_shop.models.Review;

public class ReviewMapper {
    public static Review dtoToEntity (ReviewRequestDto dto){
        return new Review(dto.id(),dto.username(), dto.rating(), dto.body());
    }

    public static ReviewResponseDto entityToDto (Review review){
        return new ReviewResponseDto(review.getUsername(), review.getRating(), review.getBody());
    }
}
