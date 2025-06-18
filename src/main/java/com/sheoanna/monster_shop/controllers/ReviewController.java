package com.sheoanna.monster_shop.controllers;

import com.sheoanna.monster_shop.dtos.review.ReviewRequestDto;
import com.sheoanna.monster_shop.dtos.review.ReviewResponseDto;
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
        URI location = URI.create("/api/reviews/" + createdReview.productId());
        return ResponseEntity.created(location).body(createdReview);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReviewResponseDto> updateReview(@PathVariable Long id, @RequestBody ReviewRequestDto newReviewDto) {
        ReviewResponseDto createdReview = reviewService.updateReview(id, newReviewDto);
        return ResponseEntity.ok(createdReview);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReviewByID(@PathVariable Long id) {
        reviewService.deleteReviewByID(id);
        return ResponseEntity.ok().build();
    }
}
