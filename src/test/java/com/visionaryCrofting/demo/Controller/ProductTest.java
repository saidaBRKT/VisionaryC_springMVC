package com.visionaryCrofting.demo.Controller;

import com.visionaryCrofting.demo.entity.Product;
import com.visionaryCrofting.demo.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductTest {
    @Autowired
    ProductService productService;
    @Test
    public void addProduct(){
        Product product=new Product("91","Null 5bb", "Cat", "fcgvhbjn", 4);
        Product res=productService.save(product);
        Assertions.assertSame(product,res);


    }


}
