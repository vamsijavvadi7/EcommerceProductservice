package com.ecommerce.product.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Lob // Marks this field as a large object, appropriate for binary data
    private byte[] productImage; // field for storing image as binary data
    private String brand;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    @JsonManagedReference
    private ProductCategory category;
    private int quantity;
    private String description;
    private int price;
}
