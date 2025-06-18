package com.sheoanna.monster_shop.controllers;

import com.sheoanna.monster_shop.dtos.product.ProductRequestDto;
import com.sheoanna.monster_shop.dtos.product.ProductResponseDto;
import com.sheoanna.monster_shop.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    @RequestMapping("")
    public ResponseEntity<List<ProductResponseDto>> index() {
        List<ProductResponseDto> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity<ProductResponseDto> showProductById(@PathVariable Long id) {
        ProductResponseDto productById = productService.getProductById(id);
        return ResponseEntity.ok(productById);
    }

    @PostMapping("")
    public ResponseEntity<ProductResponseDto> createProduct(@RequestBody ProductRequestDto newproduct) {
        ProductResponseDto savedProduct = productService.storeProduct(newproduct);
        URI location = URI.create("api/products/" + savedProduct.id());
        return ResponseEntity.created(location).body(savedProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDto> updateProduct(@PathVariable Long id, @RequestBody ProductRequestDto newProductDto) {
        ProductResponseDto updatedProduct = productService.updateProductByID(id, newProductDto);
        return ResponseEntity.ok(updatedProduct);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductByID(@PathVariable Long id) {
        productService.deleteProductByID(id);
        return ResponseEntity.ok().build();
    }
}
