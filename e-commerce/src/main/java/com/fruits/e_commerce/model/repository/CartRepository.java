package com.fruits.e_commerce.model.repository;

import com.fruits.e_commerce.model.entity.Cart;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CartRepository extends JpaRepository<Cart,Integer> {
   @Query("from Cart where user_id=?1")
    Iterable<Cart> findByUser_id(int id);

   @Transactional
    @Modifying
    @Query("delete from Cart where product_id=?1")
    void DeleteByProduct_id(int id);
}
