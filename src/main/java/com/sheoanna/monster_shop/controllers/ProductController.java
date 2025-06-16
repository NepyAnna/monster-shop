package com.sheoanna.monster_shop.controllers;

import com.sheoanna.monster_shop.dtos.product.ProductRequestDto;
import com.sheoanna.monster_shop.dtos.product.ProductResponseDto;
import com.sheoanna.monster_shop.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    @RequestMapping("")
    public ResponseEntity<List<ProductResponseDto>> showAllProducts(){
        List<ProductResponseDto> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @PostMapping("")
    public  ResponseEntity<ProductResponseDto> createProduct(@RequestBody ProductRequestDto newproduct){
        ProductResponseDto savedProduct = productService.storeProduct(newproduct);
        URI location = URI.create("/products" + savedProduct.id());
        return ResponseEntity.created(location).body(savedProduct);
    }
}
