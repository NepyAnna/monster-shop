package com.sheoanna.monster_shop.dtos.review;

public record ReviewResponseDto(Long productId, String username, double rating, String body) {
}
