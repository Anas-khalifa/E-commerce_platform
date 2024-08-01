package com.fruits.e_commerce.controller;

import com.fruits.e_commerce.model.entity.Users;
import com.fruits.e_commerce.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/user")
public class UsersController {
    @Autowired
    UsersService usersService;

    @PostMapping
    public void register(@RequestBody Users u){
        usersService.addUser(u);
    }
    @PostMapping("/login")
    public Users login(@RequestBody Users u){
       return usersService.checker(u);
    }
    @GetMapping("/{name}")
    public Users getOne(@PathVariable String name){
        return usersService.getOne(name);
    }
}
