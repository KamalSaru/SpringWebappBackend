package com.march.dbdemo.service;

import com.march.dbdemo.dao.ProductDAOImpl;
import com.march.dbdemo.dto.ProductDTO;
import com.march.dbdemo.model.AddProductRequest;
import com.march.dbdemo.model.Product;
import com.march.dbdemo.model.UpdateProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductDAOImpl productDAOImpl;

    //Post mapping---using param-----------------
    public void addProduct(String productId, String productName) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(productId);
        productDTO.setProductName(productName);
        productDAOImpl.addProduct(productDTO);
    }

    //Post mapping ----- Request Body
    public void addProduct(AddProductRequest addProductRequest) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(addProductRequest.getProductId());
        productDTO.setProductName(addProductRequest.getProductName());
        productDAOImpl.addProduct(productDTO);
    }


    //Get mapping-----------------
    public List<Product> listAllProducts() {
        List<ProductDTO> productDTOS = productDAOImpl.listAllProducts();

        List<Product> products = new ArrayList<>();
        for (ProductDTO productDTO : productDTOS) {
            Product product = new Product();
            product.setProductId(productDTO.getProductId());
            product.setProductName(productDTO.getProductName());
            products.add(product);
        }
        return products;
    }

    //Put mapping--------------------
    public void updateProduct(UpdateProductRequest updateProductRequest) {
        ProductDTO productDTO = productDAOImpl.findByProductId(updateProductRequest.getProductId());
        productDTO.setProductName(updateProductRequest.getProductName());
        productDAOImpl.updateProduct(productDTO);
    }

    //Delete mapping ------------Use Request Param
    public void deleteProduct(String productId) {
        ProductDTO productDTO = productDAOImpl.findByProductId(productId);
        productDAOImpl.deleteProduct(productDTO);
    }
}
