package com.sheoanna.monster_shop.dtos.product;

import jakarta.validation.constraints.*;

public record ProductResponseDto(Long id,
                              String name,
                              double price,
                              String imageUrl,
                              double rating,
                              int reviewCount,
                              boolean featured) {
}
