package com.sheoanna.monster_shop.services;

import com.sheoanna.monster_shop.dtos.product.ProductMapper;
import com.sheoanna.monster_shop.dtos.product.ProductRequestDto;

import com.sheoanna.monster_shop.dtos.product.ProductResponseDto;
import com.sheoanna.monster_shop.exception.product.ProductAlreadyExistsException;
import com.sheoanna.monster_shop.exception.product.ProductNotFoundException;
import com.sheoanna.monster_shop.models.Product;
import com.sheoanna.monster_shop.models.Review;
import com.sheoanna.monster_shop.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {
    private  final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductResponseDto> getAllProducts(){
        List<Product> products = productRepository.findAll();
        return products.stream().map(product -> ProductMapper.entityToDto(product)).toList();
    }

    public ProductResponseDto getProductById(Long id) {
       Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product with id " + id + " not found!"));

       return ProductMapper.entityToDto(product);
    }

    @Transactional
    public ProductResponseDto storeProduct(ProductRequestDto newProduct) {
        if(productRepository.findByName(newProduct.name()) != null){
            throw new ProductAlreadyExistsException("Monster with such name already exist!");
        }
        Product product = ProductMapper.dtoToEntity(newProduct);
        Product savedProduct = productRepository.save(product);
        return ProductMapper.entityToDto(savedProduct);
    }

    @Transactional
    public void updateRatingAndCount(Product product) {
        List<Review> reviews = product.getReviews();

        int count = reviews.size();
        double avgRating = reviews.stream()
                .mapToDouble(Review::getRating)
                .average()
                .orElse(0.0);

        product.setReviewCount(count);
        product.setRating(avgRating);

        productRepository.save(product);
    }
}
