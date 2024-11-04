package com.ecommerce.product.dto;

import com.ecommerce.product.model.Product;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
@Data
@RequiredArgsConstructor
public class ProductCategoryDTO {
        private String categoryname;
        private String description;


}
