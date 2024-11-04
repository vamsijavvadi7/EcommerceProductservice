package com.ecommerce.product.controller;

import com.ecommerce.product.Dao.ProductCategoryRepo;
import com.ecommerce.product.Dao.ProductRepo;
import com.ecommerce.product.dto.ProductCategoryDTO;
import com.ecommerce.product.dto.ProductDto;
import com.ecommerce.product.model.Product;
import com.ecommerce.product.model.ProductCategory;
import com.ecommerce.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("product")
@RestController
public class ProductController {
    @Autowired
    ProductRepo productRepo;


    @Autowired
    ProductCategoryRepo productCategoryRepo;

    @Autowired
    ProductService productService;

  //add product
    @PostMapping("/addProduct")
    public ResponseEntity<?> addProduct(@RequestBody ProductDto p) {
        return productService.addProduct(p);
    }
    //add category
    @PostMapping("/addCategory")
    public ProductCategory addCategory(@RequestBody ProductCategoryDTO p) {
        return productService.addCategory(p);
    }


    //Servlet to get All products
    @GetMapping("/getAllCategorys")
    public List<ProductCategory> getAllCategorys() {
        return productCategoryRepo.findAll();
    }

    //Delete Product
    @DeleteMapping("/deleteProduct/{id}")
    public void deleteProduct(@PathVariable int id) {
        productRepo.deleteById(id);
    }

    //Update Product
    @PutMapping("/updateProduct")
    public void updateProduct(@RequestBody Product p) {
        productRepo.save(p);
    }


    //Servlet to get All products
    @GetMapping("/getAllProducts")
    public List<Product> getProducts() {
return productRepo.findAll();
    }



    //Servlet to get All products
    @GetMapping("/getProductsByCategory/{category}")
    public List<Product> getProductsByCategory(@PathVariable String category) {
        return productRepo.findByCategory(category);
    }

    //Servlet to get product by id
    @GetMapping("/getProduct/{id}")
    public Optional<Product> getProductByID(@PathVariable int id) {
        return productRepo.findById(id);
    }

}
