package com.sheoanna.monster_shop.repositories;

import com.sheoanna.monster_shop.models.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByName(@NotBlank @Size(min = 2, max = 50, message = "Name is required.") String name);

}
