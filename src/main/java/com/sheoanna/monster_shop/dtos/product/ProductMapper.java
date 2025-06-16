package com.sheoanna.monster_shop.dtos.product;

import com.sheoanna.monster_shop.models.Product;

public class ProductMapper {
    public static Product dtoToEntity (ProductRequestDto dto){
        return new Product(dto.name(),dto.price(), dto.imageUrl(), dto.rating(), dto.reviewCount(), dto.featured());
    }

    public static ProductResponseDto entityToDto (Product product){
        return new ProductResponseDto(product.getId(),product.getName(),product.getPrice(), product.getImageUrl(), product.getRating(),product.getReviewCount(),product.isFeatured());
    }
}
