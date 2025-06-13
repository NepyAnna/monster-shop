package com.sheoanna.monster_shop.repositories;

import com.sheoanna.monster_shop.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
