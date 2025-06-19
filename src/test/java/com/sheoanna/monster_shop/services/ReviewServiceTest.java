package com.sheoanna.monster_shop.services;

import com.sheoanna.monster_shop.dtos.review.ReviewMapper;
import com.sheoanna.monster_shop.dtos.review.ReviewRequestDto;
import com.sheoanna.monster_shop.dtos.review.ReviewResponseDto;
import com.sheoanna.monster_shop.models.Product;
import com.sheoanna.monster_shop.models.Review;
import com.sheoanna.monster_shop.repositories.ProductRepository;
import com.sheoanna.monster_shop.repositories.ReviewRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ReviewServiceTest {
    @Mock
    private ReviewMapper reviewMapper;
    @Mock
    private ReviewRepository reviewRepository;

    @Mock
    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ReviewService reviewService;

    @BeforeEach
    public void setUp(){
        this.reviewService = new ReviewService(reviewRepository, productRepository, productService);
    }

    @Test
    void testGetReviewsByProductId() {
        Long productId = 1L;
        Product product = new Product(productId, "Monster", 3.5, true, 0.0, 0);

        Review review1 = new Review(1L, "User1", 4.0,"Great",  product);
        Review review2 = new Review(2L, "User2", 3.0,"Not bad",  product);

        when(reviewRepository.findByProductId(productId)).thenReturn(List.of(review1, review2));

        List<ReviewResponseDto> result = reviewService.getReviewsByProductId(productId);

        assertEquals(2, result.size());
        assertEquals("User1", result.get(0).username());
        assertEquals("User2", result.get(1).username());
    }

    @Test
    void testGetReviewById() {
        Long reviewId = 1L;
        Product product = new Product(1L, "Monster", 3.5, true, 0.0, 0);
        Review review = new Review(reviewId,"User1", 5.0, "Awesome!", product);

        when(reviewRepository.findById(reviewId)).thenReturn(Optional.of(review));

        ReviewResponseDto result = reviewService.getReviewById(reviewId);

        assertEquals("User1", result.username());
        assertEquals("Awesome!", result.body());
        assertEquals(5.0, result.rating());
    }

    @Test
    void testStoreReview() {
        Long productId = 1L;
        Product product = new Product(productId, "Monster", 3.5, true, 0.0, 0);
        ReviewRequestDto dto = new ReviewRequestDto(productId,"User1", 5.0, "Cool");
        Review review = new Review(null, "User1", 5.0,"Cool",  null);
        Review savedReview = new Review(10L, "User1", 5.0,"Cool",  product); // з ID після збереження
        ReviewResponseDto expectedDto = new ReviewResponseDto(productId, "User1", 5.0,"Cool");

        when(productRepository.findById(productId)).thenReturn(Optional.of(product));

        try (MockedStatic<ReviewMapper> mocked = mockStatic(ReviewMapper.class)) {
            mocked.when(() -> ReviewMapper.dtoToEntity(dto)).thenReturn(review);
            mocked.when(() -> ReviewMapper.entityToDto(any(Review.class))).thenReturn(expectedDto);

            when(reviewRepository.save(review)).thenReturn(savedReview);

            ReviewResponseDto result = reviewService.storeReview(dto);

            assertEquals(expectedDto, result);
            verify(productService).updateRatingAndCount(product);
            verify(reviewRepository).save(review);
        }
    }


    @Test
    void testDeleteReviewByID() {
        Long reviewId = 1L;
        Product product = new Product(1L, "Monster", 3.5, true, 0.0, 0);
        Review review = new Review(reviewId, "User1", 4.0, "Nice", product);

        when(reviewRepository.findById(reviewId)).thenReturn(Optional.of(review));

        reviewService.deleteReviewByID(reviewId);

        verify(reviewRepository, times(1)).deleteById(reviewId);
        verify(productService, times(1)).updateRatingAndCount(product);
    }
}