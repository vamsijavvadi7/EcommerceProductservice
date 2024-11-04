package com.ecommerce.product.Dao;

import com.ecommerce.product.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;



public interface ProductCategoryRepo extends JpaRepository<ProductCategory, Integer> {
    Optional<ProductCategory> findByCategoryname(String categoryname);
}
