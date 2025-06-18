package com.sheoanna.monster_shop.dtos.product;

import com.sheoanna.monster_shop.dtos.review.ReviewResponseDto;

import java.util.List;

public record ProductResponseDto(Long id,
                                 String name,
                                 double price,
                                 String imageUrl,
                                 double rating,
                                 int reviewCount,
                                 boolean featured,
                                 List<ReviewResponseDto> reviews
) {
}
