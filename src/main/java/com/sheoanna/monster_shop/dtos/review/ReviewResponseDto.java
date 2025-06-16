package com.sheoanna.monster_shop.dtos.review;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ReviewResponseDto(String username, double rating, String body) {
}
