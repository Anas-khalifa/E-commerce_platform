package com.fruits.e_commerce.model.repository;

import com.fruits.e_commerce.model.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductsRepository extends JpaRepository<Products,Integer> {
    @Query("from Products order by name")
    Iterable<Products> productsOrderdByName();
    @Query("from Products order by price")
    Iterable<Products> productsOrderdByPrice();
    @Query("from Products order by id desc")
    Iterable<Products> productsOrderdByNewst();

}
