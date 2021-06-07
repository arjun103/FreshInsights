package com.example.freshinsights.controller;

import com.example.freshinsights.model.Products;
import com.example.freshinsights.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/freshinsights")
public class ProductsController
{
    @Autowired
    ProductsService productsService;

    @PostMapping("/products")
    void createProduct(@RequestBody Products products){productsService.createProduct(products);}

    @GetMapping("/products")
    List<Products> findAllProducts()
    {
        return productsService.findAllProducts();
    }

    @GetMapping("/products/{id}")
    Products findProductByID(@PathVariable BigInteger id)
    {
        return productsService.findProductByID(id);
    }

    @DeleteMapping("/products/{id}")
    void deleteProduct(@PathVariable  BigInteger id)
    {
        productsService.deleteProduct(id);
    }
}
