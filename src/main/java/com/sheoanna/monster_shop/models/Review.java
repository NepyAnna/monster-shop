package com.sheoanna.monster_shop.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name="reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private double rating;
    private String body;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    public Review() {
    }

    public Review(String username, double rating, String body) {
        this.username = username;
        this.rating = rating;
        this.body = body;
    }

    public Review(Long id, String username, double rating, String body) {
        this.id = id;
        this.username = username;
        this.rating = rating;
        this.body = body;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public double getRating() {
        return rating;
    }

    public String getBody() {
        return body;
    }

    public Product getProduct() {
        return product;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
