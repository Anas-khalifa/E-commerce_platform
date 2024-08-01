package com.fruits.e_commerce.model.repository;

import com.fruits.e_commerce.model.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsersRepository extends JpaRepository<Users,Integer> {
    @Query("from Users where user_name=?1")
    Users findByUser_name(String username);

    @Query("from Users where user_name=?1 and pass=?2")
    Users findByUser_nameAndPass(String username, String pass);

}
