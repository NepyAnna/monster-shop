package com.sheoanna.monster_shop.dtos.review;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ReviewRequestDto(Long id,
                               @NotBlank(message = "Username is required")
                               @Size(max = 50, message = "Username must be at most 50 characters")
                               String username,

                               @DecimalMin(value = "0.0", inclusive = true, message = "Rating must be at least 0.0")
                               @DecimalMax(value = "5.0", inclusive = true, message = "Rating must be at most 5.0")
                               double rating,

                               @NotBlank(message = "Review body must not be blank")
                               @Size(max = 1000, message = "Review must be at most 1000 characters")
                               String body) {
}
