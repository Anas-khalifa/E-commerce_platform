package com.fruits.e_commerce.controller;

import com.fruits.e_commerce.model.entity.Products;
import com.fruits.e_commerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/{name}/{price}/{quantity}")
    public void addProduct(@PathVariable String name,@PathVariable int price,@PathVariable int quantity, @RequestParam("imageFile") MultipartFile imageFile) throws IOException, IOException{
        productService.addProduct(name,price,quantity,imageFile);
    }
    @GetMapping("/Oldest")
    public List<Products> allProducts(){
       return productService.getAllProducts();
    }
    @GetMapping("/Name")
    public Iterable<Products> nameOrder(){
       return productService.productOrderdName();
    }
    @GetMapping("/Price")
    public Iterable<Products> PriceOrder(){
       return productService.productsOrderPrice();
    }
    @GetMapping("/Newest")
    public Iterable<Products> newestorder(){
       return productService.productOrderNewest();
    }
    @GetMapping("/{id}")
    public Products getById(@PathVariable int id){
        return productService.getProduct(id);
    }

}
