package com.ecommerce.product.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ProductDto {
    private String name;
    private String brand;
    private String category;// This will hold the category name
    private String categorydescription;
    private int quantity;
    private String description;
    private int price;
}
