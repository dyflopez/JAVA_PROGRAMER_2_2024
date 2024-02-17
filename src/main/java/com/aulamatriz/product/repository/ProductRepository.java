package com.aulamatriz.product.repository;

import com.aulamatriz.product.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {


    //@Query("Select product FROM ProductEntity product WHERE product.name = :name")
    Optional<ProductEntity> findByName(String name);
    //@Query("SELECT prodcut FROM  ProductEntity  prodcut WHERE product.name = :name AND product.price = :price")
    Optional<ProductEntity> findByNameAndPrice(String name, BigDecimal price);

    Optional<ProductEntity> findByNameAndStockGreaterThan(String name, int stock);

}
