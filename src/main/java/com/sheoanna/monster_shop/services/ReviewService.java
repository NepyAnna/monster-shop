package com.sheoanna.monster_shop.services;

import com.sheoanna.monster_shop.dtos.review.ReviewMapper;
import com.sheoanna.monster_shop.dtos.review.ReviewRequestDto;
import com.sheoanna.monster_shop.dtos.review.ReviewResponseDto;
import com.sheoanna.monster_shop.exception.product.ProductNotFoundException;
import com.sheoanna.monster_shop.models.Product;
import com.sheoanna.monster_shop.models.Review;
import com.sheoanna.monster_shop.repositories.ProductRepository;
import com.sheoanna.monster_shop.repositories.ReviewRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final ProductRepository productRepository;
    private final ProductService productService;

    public ReviewService(ReviewRepository reviewRepository, ProductRepository productRepository, ProductService productService) {
        this.reviewRepository = reviewRepository;
        this.productRepository = productRepository;
        this.productService = productService;
    }

    public List<ReviewResponseDto> getAllReviews(){
        List<Review> reviews = reviewRepository.findAll();
        return reviews.stream().map(review -> ReviewMapper.entityToDto(review)).toList();
    }

    @Transactional
    public ReviewResponseDto createReview(Long productId, ReviewRequestDto dto) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));

        Review review = ReviewMapper.dtoToEntity(dto);

        review.setProduct(product);//??? or put to dtos as args if posible change models from requirements

        reviewRepository.save(review);

        productService.updateRatingAndCount(product);

        return ReviewMapper.entityToDto(review);
    }
}
