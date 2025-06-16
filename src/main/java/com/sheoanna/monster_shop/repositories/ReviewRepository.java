package com.sheoanna.monster_shop.repositories;

import com.sheoanna.monster_shop.models.Review;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
