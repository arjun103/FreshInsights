package com.example.freshinsights.repository;

import com.example.freshinsights.model.Products;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends CrudRepository<Products, Integer>
{

}
