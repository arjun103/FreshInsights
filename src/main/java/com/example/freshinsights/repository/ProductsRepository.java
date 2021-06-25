package com.example.freshinsights.repository;

import com.example.freshinsights.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.math.BigInteger;


@Repository
public interface ProductsRepository extends JpaRepository<Products, BigInteger>
{
    @Query(value = "SELECT * FROM Products WHERE productId = ?", nativeQuery = true)
    Products findProductDeatilsUsingId(BigInteger productId);
}
