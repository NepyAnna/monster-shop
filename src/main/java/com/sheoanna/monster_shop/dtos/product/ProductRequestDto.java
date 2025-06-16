package com.sheoanna.monster_shop.dtos.product;

import jakarta.validation.constraints.*;

public record ProductRequestDto(@Null
                                Long id,
                                @NotBlank
                                @Size(min = 2, max = 50, message = "Name is required.")
                                String name,

                                @Positive(message = "Price must be greater than 0.")
                                double price,

                                @NotBlank(message = "Image URL is required.")
                                String imageUrl,

                                @DecimalMin(value = "0.0", message = "Rating must be >= 0.0")
                                @DecimalMax(value = "5.0", message = "Rating must be <= 5.0")
                                double rating,

                                @Min(value = 0, message = "Review count must be 0 or more.")
                                int reviewCount,

                                boolean featured) {

}
