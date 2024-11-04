package com.ecommerce.product.service;

import com.ecommerce.product.Dao.ProductCategoryRepo;
import com.ecommerce.product.Dao.ProductRepo;
import com.ecommerce.product.dto.ProductCategoryDTO;
import com.ecommerce.product.dto.ProductDto;
import com.ecommerce.product.model.Product;
import com.ecommerce.product.model.ProductCategory;
import com.ecommerce.product.service.mappers.HelperMapper;
import jakarta.transaction.Transactional;
import org.hibernate.tool.schema.extract.spi.ExtractionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductService {


    @Autowired
    HelperMapper helperMapper;
    @Autowired
    ProductCategoryRepo productCategoryRepo;

    @Autowired
    ProductRepo productRepo;

    @Transactional
    public ResponseEntity<?> addProduct(ProductDto productDTO) {

        ProductCategory category = productCategoryRepo.findByCategoryname(productDTO.getCategory())
                .orElseGet(() -> {
                    ProductCategory newCategory = new ProductCategory();
                    newCategory.setCategoryname(productDTO.getCategory());
                    newCategory.setDescription(productDTO.getCategorydescription());
                    return productCategoryRepo.save(newCategory);
                });
        // Map ProductDTO to Product entity
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setBrand(productDTO.getBrand());
        product.setCategory(category);
        product.setQuantity(productDTO.getQuantity());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(productRepo.save(product));
        } catch (DataAccessException e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to save product due to an internal error related to database.");
        }catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to save product due to an internal error.");
        }

    }

    public ProductCategory addCategory(ProductCategoryDTO p) {

        ProductCategory productCategory = helperMapper.toEntity(p);
        return productCategoryRepo.save(productCategory);

    }
}
