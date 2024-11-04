package com.ecommerce.product.Dao;

import com.ecommerce.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {
    @Query("SELECT p FROM Product p JOIN p.category c WHERE c.categoryname = :category")
    List<Product> findByCategory(String category);

}
