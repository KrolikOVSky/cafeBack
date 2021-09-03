package com.ivr.cafeback.controllers;

import com.ivr.cafeback.entity.model.in.CreateProductModel;
import com.ivr.cafeback.entity.model.in.UpdateProductModel;
import com.ivr.cafeback.entity.model.out.ProductModel;
import com.ivr.cafeback.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductModel> getProducts() {
        return productService.getAllModels();
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody CreateProductModel createdModel) {
        try {
            productService.createProduct(createdModel);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<?> updateProduct(@RequestBody UpdateProductModel updatedModel) {
        try {
            productService.updateProduct(updatedModel);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/del")
    public List<ProductModel> getDeletedModels() {
        return productService.getAllDeletedModels();
    }

}
