package com.example.freshinsights.service;

import com.example.freshinsights.model.Employee;
import com.example.freshinsights.model.Products;
import com.example.freshinsights.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService
{
    @Autowired
    ProductsRepository productsRepository;

    public void createProduct(Products products) {productsRepository.save(products);}

    public void deleteProduct(int id) {productsRepository.deleteById(id);
    }

    public List<Products> findAllProducts() {return (List<Products>) productsRepository.findAll();
    }

    public Products findProductByID(int id) {return productsRepository.findById(id).get();
    }
}
