package com.fruits.e_commerce.service;

import com.fruits.e_commerce.model.entity.Cart;
import com.fruits.e_commerce.model.entity.Products;
import com.fruits.e_commerce.model.repository.CartRepository;
import com.fruits.e_commerce.model.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {
    @Autowired
    CartRepository cartRepo;
    @Autowired
    ProductsRepository productsRepo;

    @Autowired
    JavaMailSender mailSender;
    public void addCart(Cart c){
        cartRepo.save(c);
    }
    public Iterable<Cart> getCartByUid(int id){
        return cartRepo.findByUser_id(id);
    }
    public Iterable<Products> getProductsByCart(int id){
        List<Products> outPutProducts=new ArrayList<>();

        List<Cart> cartList= (List<Cart>) cartRepo.findByUser_id(id);

        List<Products> productsList= (List<Products>) productsRepo.findAll();
        for(Products p:productsList){
            for(Cart c:cartList){
                if(p.getId()==c.getProduct_id()){
                    outPutProducts.add(p);
                }
            }
        }
        return outPutProducts;
    }
    public void deleteCart(int id){
        cartRepo.DeleteByProduct_id(id);
    }
    @Value("$(spring.mail.username)")
    private String fromMail;
    public void sendMail(String mail,String address,int user_id){
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();

        List<Products> productList= (List<Products>) getProductsByCart(user_id);
        String productString="";
        for(Products p:productList){
            productString+=p.getName()+"\n";
        }

        simpleMailMessage.setFrom(fromMail);
        simpleMailMessage.setSubject("Thank You For Choosing Fruitables");
        simpleMailMessage.setText("You have bought the following items : \n"+productString+"\nAddress :"+address);
        simpleMailMessage.setTo(mail);

        mailSender.send(simpleMailMessage);
    }
}
