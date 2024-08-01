package com.fruits.e_commerce.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String full_name;
    @Column
    private int age ;
    @Column
    private String address;
    @Column
    private String phone_number ;
    @Column
    private String gender;
    @Column
    private boolean access;
    @Column
    private String pass;
    @Column
    private String user_name;
    @Column
    private String role_name;
}
