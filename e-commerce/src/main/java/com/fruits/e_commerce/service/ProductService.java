package com.fruits.e_commerce.service;

import com.fruits.e_commerce.model.entity.Products;
import com.fruits.e_commerce.model.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductsRepository productRepository;

    //save product
public static  String uploadDirectory="C:/Users/Anas Khalifah/Desktop/E-Commerce/E-commerce/src/assets/imageFromApi";
    public void addProduct(String name,int price,int quantity,
                           @RequestParam MultipartFile img) throws IOException {


        String originalFileName=img.getOriginalFilename();

        Path uploadPath= Path.of(uploadDirectory);
        Path filePath = uploadPath.resolve(originalFileName);


            Files.createDirectories(uploadPath);
        Files.copy(img.getInputStream(),filePath, StandardCopyOption.REPLACE_EXISTING);

        Products p=new Products();

        p.setProduct_image(originalFileName);
        p.setName(name);
        p.setPrice(price);
        p.setQuantity(quantity);
        p.setRating(3);
        productRepository.save(p);
    }
    //get all products
    public List<Products> getAllProducts(){
        return productRepository.findAll();
    }
    //get by id
    public Products getProduct(int id){
        return productRepository.getReferenceById(id);
    }
    public Iterable<Products> productOrderdName(){
        return productRepository.productsOrderdByName();
    }
    public Iterable<Products> productsOrderPrice(){
        return productRepository.productsOrderdByPrice();
    }
    public Iterable<Products> productOrderNewest(){
        return productRepository.productsOrderdByNewst();
    }



}
