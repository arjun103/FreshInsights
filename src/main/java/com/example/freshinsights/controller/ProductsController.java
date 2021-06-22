package com.example.freshinsights.controller;

import com.example.freshinsights.model.FlowSteps;
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

    @PostMapping("/product")
    void createProduct(@RequestBody Products products){productsService.createProduct(products);}

    @GetMapping("/products")
    List<Products> findAllProducts()
    {
        return productsService.findAllProducts();
    }

    @GetMapping("/product/{id}")
    Products findProductByID(@PathVariable BigInteger id)
    {
        return productsService.findProductByID(id);
    }

    @DeleteMapping("/product/{id}/delete")
    void deleteProduct(@PathVariable  BigInteger id)
    {
        productsService.deleteProduct(id);
    }

    @GetMapping("/product/productId/{productid}")
    List<Products> findProductDeatilsUsingId(@PathVariable("productid") BigInteger productId)
    {
        return productsService.findProductDeatilsUsingId(productId);
    }
}
