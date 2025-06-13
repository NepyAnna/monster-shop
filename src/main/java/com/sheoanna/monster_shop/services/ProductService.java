package com.sheoanna.monster_shop.services;

import com.sheoanna.monster_shop.dtos.product.ProductMapper;
import com.sheoanna.monster_shop.dtos.product.ProductRequest;
import com.sheoanna.monster_shop.dtos.product.ProductResponse;

import com.sheoanna.monster_shop.exception.product.ProductAlreadyExistsException;
import com.sheoanna.monster_shop.models.Product;
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

    public List<ProductResponse> getAllProducts(){
        List<Product> products = productRepository.findAll();
        return products.stream().map(product -> ProductMapper.entityToDto(product)).toList();
    }

    @Transactional
    public ProductResponse storeProduct(ProductRequest newProduct) {
        if(productRepository.findByName(newProduct.name()) != null){
            throw new ProductAlreadyExistsException("Monster with such name already exist!");
        }
        Product product = ProductMapper.dtoToEntity(newProduct);
        Product savedProduct = productRepository.save(product);
        return ProductMapper.entityToDto(savedProduct);
    }
}
