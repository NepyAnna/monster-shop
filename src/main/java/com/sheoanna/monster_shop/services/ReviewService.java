package com.sheoanna.monster_shop.services;

import com.sheoanna.monster_shop.dtos.review.ReviewMapper;
import com.sheoanna.monster_shop.dtos.review.ReviewRequestDto;
import com.sheoanna.monster_shop.dtos.review.ReviewResponseDto;
import com.sheoanna.monster_shop.exception.product.ProductNotFoundException;
import com.sheoanna.monster_shop.exception.review.ReviewNotFoundException;
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

    public List<ReviewResponseDto> getReviewsByProductId(Long productId) {
        List<Review> reviews = reviewRepository.findByProductId(productId);
        return reviews.stream()
                .map(ReviewMapper::entityToDto)
                .toList();
    }

    public ReviewResponseDto getReviewById(Long id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new ReviewNotFoundException("Review with id " + id + " not found!"));

        return ReviewMapper.entityToDto(review);
    }

    @Transactional
    public ReviewResponseDto storeReview(ReviewRequestDto dto) {
        Product product = productRepository.findById(dto.productId())
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));

        Review review = ReviewMapper.dtoToEntity(dto);
        review.setProduct(product);
        reviewRepository.save(review);
        productService.updateRatingAndCount(product);

        return ReviewMapper.entityToDto(review);
    }

    public void deleteReviewByID(Long id) {
        if (!reviewRepository.existsById(id)) {
            throw new ReviewNotFoundException("Review with id " + id + " not found!");
        }
        reviewRepository.deleteById(id);
    }
}
