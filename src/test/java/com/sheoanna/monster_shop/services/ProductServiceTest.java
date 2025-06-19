package com.sheoanna.monster_shop.services;

import com.sheoanna.monster_shop.dtos.product.ProductResponseDto;
import com.sheoanna.monster_shop.exception.product.ProductNotFoundException;
import com.sheoanna.monster_shop.models.Product;
import com.sheoanna.monster_shop.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @BeforeEach
    public void setUp() {
        this.productService = new ProductService(productRepository);
    }

    @Test
    void testGetAllProducts() {
        List<Product> productList = new ArrayList<Product>();
        Product product1 = new Product("Monster1",
                3.55,
                "https://images.unsplash.com/photo-1588422333078-44ad73367bcb?q=80&w=2574&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                0.0,
                0,
                true);
        Product product2 = new Product("Monster2",
                3.55,
                "https://images.unsplash.com/photo-1588422333078-44ad73367bcb?q=80&w=2574&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                0.0,
                0,
                true);

        productList.add(product1);
        productList.add(product2);

        when(productRepository.findAll()).thenReturn(productList);

        List<ProductResponseDto> resultList = productService.getAllProducts();

        assertEquals(2, resultList.size());
        assertEquals("Monster1", resultList.get(0).name());
        assertEquals("Monster2", resultList.get(1).name());
    }

    @Test
    void testGetProductById() {
        Product product1 = new Product(1L,
                "Monster1",
                3.55,
                true,
                0.0,
                0);

        when(productRepository.findById(1L)).thenReturn(Optional.of(product1));

        ProductResponseDto result = productService.getProductById(1L);

        assertEquals("Monster1", result.name());
        assertEquals(1L, result.id());
        assertTrue(result.featured());
    }

    @Test
    void testDeleteProductByIdSuccess() {
        Long productId = 1L;
        when(productRepository.existsById(productId)).thenReturn(true);

        productService.deleteProductByID(productId);

        verify(productRepository).deleteById(productId);
    }

    @Test
    void testDeleteProductByIdNotFound() {
        Long productId = 2L;

        when(productRepository.existsById(productId)).thenReturn(false);

        assertThrows(ProductNotFoundException.class, () -> {
            productService.deleteProductByID(productId);
        });
        verify(productRepository, never()).deleteById(anyLong());
    }
}