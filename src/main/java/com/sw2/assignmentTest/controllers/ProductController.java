package com.sw2.assignmentTest.controllers;

import com.sw2.assignmentTest.bsl.ProductLogic;
import com.sw2.assignmentTest.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController
{
    @RequestMapping(value = "/products",method = RequestMethod.POST)
    public String addProduct(@RequestBody Product product)
    {
        return ProductLogic.add(product);
    }

    @GetMapping(value = "/products/{serial}")
    public Product getProduct(@PathVariable("serial") int serial) {
        return ProductLogic.getProduct(serial);
    }

    @GetMapping(value = "/allProducts")
    public List<Product> getProduct()
    {
        return ProductLogic.getProducts();
    }

}
