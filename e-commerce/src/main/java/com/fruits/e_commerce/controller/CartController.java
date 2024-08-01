package com.fruits.e_commerce.controller;

import com.fruits.e_commerce.model.entity.Cart;
import com.fruits.e_commerce.model.entity.Products;
import com.fruits.e_commerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    CartService cartService;

    @PostMapping
    public void addcart(@RequestBody Cart c){
        cartService.addCart(c);
    }
    @GetMapping("/{id}")
    public Iterable<Cart> getOne(@PathVariable int id){
        return cartService.getCartByUid(id);
    }
    @GetMapping("/specific/{id}")
    public Iterable<Products> getproduct(@PathVariable int id){
        return cartService.getProductsByCart(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCart(@PathVariable int id){
        cartService.deleteCart(id);
    }
    @GetMapping("/checkout/{mail}/{address}/{user_id}")
    public void sendMail(@PathVariable String mail,@PathVariable String address,@PathVariable int user_id ){
        cartService.sendMail(mail,address,user_id);
    }
}
