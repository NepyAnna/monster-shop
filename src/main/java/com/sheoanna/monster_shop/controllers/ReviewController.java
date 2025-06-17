package com.sheoanna.monster_shop.controllers;

import com.sheoanna.monster_shop.dtos.review.ReviewRequestDto;
import com.sheoanna.monster_shop.dtos.review.ReviewResponseDto;
import com.sheoanna.monster_shop.exception.product.ProductNotFoundException;
import com.sheoanna.monster_shop.services.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/{productId}")
    public ResponseEntity<List<ReviewResponseDto>> getReviewsByProductId(@PathVariable Long productId) {
        List<ReviewResponseDto> reviews = reviewService.getReviewsByProductId(productId);
        return ResponseEntity.ok(reviews);
    }

    @PostMapping("")
    public ResponseEntity<ReviewResponseDto> createReview(@RequestBody ReviewRequestDto newReviewDto) {
        ReviewResponseDto createdReview = reviewService.storeReview(newReviewDto);
        return ResponseEntity.ok().body(createdReview);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductByID(@PathVariable Long id) {
        reviewService.deleteReviewByID(id);
        return ResponseEntity.ok().build();
    }
}
