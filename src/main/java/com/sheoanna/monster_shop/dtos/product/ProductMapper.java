package com.sheoanna.monster_shop.dtos.product;

import com.sheoanna.monster_shop.dtos.review.ReviewMapper;
import com.sheoanna.monster_shop.dtos.review.ReviewResponseDto;
import com.sheoanna.monster_shop.models.Product;

import java.util.List;

public class ProductMapper {
    public static Product dtoToEntity(ProductRequestDto dto) {
        return new Product(dto.name(), dto.price(), dto.imageUrl(), dto.rating(), dto.reviewCount(), dto.featured());
    }

    public static ProductResponseDto entityToDto(Product product) {
        List<ReviewResponseDto> reviewDtos = product.getReviews().stream()
                .map(ReviewMapper::entityToDto)
                .toList();
        return new ProductResponseDto(product.getId(), product.getName(), product.getPrice(), product.getImageUrl(), product.getRating(), product.getReviewCount(), product.isFeatured(), reviewDtos);
    }
}
