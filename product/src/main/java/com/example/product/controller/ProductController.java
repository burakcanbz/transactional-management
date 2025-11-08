package com.example.product.controller;


import com.example.product.dto.CreateProductDTO;
import com.example.product.dto.UpdateProductDTO;
import com.example.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public String getProducts() {
        return "get all products";
    }

    @GetMapping("/{productId}")
    public String getProductById(@PathVariable String productId) {
        return "get product by id " + productId;
    }

    @PostMapping
    public String createProduct(@RequestBody CreateProductDTO createProductDTO) {
        return "create product";
    }

    @PutMapping
    public String updateProduct(@RequestBody UpdateProductDTO updateProductDTO) {
        return "update product";
    }

    @PatchMapping
    public String partialUpdateProduct(@RequestBody UpdateProductDTO updateProductDTO) {
        return "update product";
    }

    @DeleteMapping
    public String deleteProductById(@RequestBody Long id) {
        return "delete product";
    }
}
