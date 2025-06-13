package com.sheoanna.monster_shop.dtos.product;

import jakarta.validation.constraints.*;

public record ProductResponse(Long id,
                              String name,
                              double price,
                              String imageUrl,
                              double rating,
                              int reviewCount,
                              boolean featured) {
}
