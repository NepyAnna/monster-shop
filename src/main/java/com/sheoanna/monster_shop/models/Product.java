package com.sheoanna.monster_shop.models;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name", length = 50, nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name="image_url", nullable = false)
    private String imageUrl;

    @Column(name="rating")
    private double rating;

    @Column(name="review_count", length = 50)
    private int reviewCount;

    @Column(name = "featured")
    private boolean featured;

    public Product() {
    }

    public Product(String name, double price, String imageUrl, double rating, int reviewCount, boolean featured) {
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
        this.rating = rating;
        this.reviewCount = reviewCount;
        this.featured = featured;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public double getRating() {
        return rating;
    }

    public int getReviewCount() {
        return reviewCount;
    }

    public boolean isFeatured() {
        return featured;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }
}
