package com.march.dbdemo.controller;

import com.march.dbdemo.model.AddProductRequest;
import com.march.dbdemo.model.UpdateProductRequest;
import com.march.dbdemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Value("${successfull.message}")
    private String successfulMessage;

    @Autowired
    private ProductService productService;

    @PostMapping(value = "/product/action/add")
    //Use Request Param
    //http://localhost:8080/product/action/add
    public ResponseEntity<?> addProduct(@RequestParam String productId, @RequestParam String productName) {
        productService.addProduct(productId, productName);
        return new ResponseEntity<>(successfulMessage, HttpStatus.OK);
    }

    @PostMapping(value = "/product/action/add1")
    //Use Request Body
    //http://localhost:8080/product/action/add1
    public ResponseEntity<?> addProduct1(@RequestBody AddProductRequest addProductRequest) {
        productService.addProduct(addProductRequest);
        return new ResponseEntity<>(successfulMessage, HttpStatus.OK);
    }

    @GetMapping(value = "/product/action/list-all")
    //http://localhost:8080/product/action/list-all
    public ResponseEntity<?> listAllProducts() {
        return new ResponseEntity<>(productService.listAllProducts(), HttpStatus.OK);
    }

    @PutMapping(value = "/product/action/update")
    //localhost:8080/product/action/update
    public ResponseEntity<?> updateProduct(@RequestBody UpdateProductRequest updateProductRequest) {
        productService.updateProduct(updateProductRequest);
        return new ResponseEntity<>("Product updated successfully.", HttpStatus.OK);
    }

    @DeleteMapping(value = "/product/action/delete")
    //Use Request Param
    //http://localhost:8080product/action/delete
    public ResponseEntity<?> deleteProduct(@RequestParam String productId) {
        productService.deleteProduct(productId);
        return new ResponseEntity<>("Product deleted successfully.", HttpStatus.OK);
    }
}
