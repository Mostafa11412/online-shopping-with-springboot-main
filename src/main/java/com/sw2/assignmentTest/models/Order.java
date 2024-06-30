package com.sw2.assignmentTest.models;

import java.util.ArrayList;
import java.util.List;

public class Order {
    public static List<Integer> orderedProducts = new ArrayList<>();
    public static String  customer;

    public Order(List<Integer> orderedProducts , String  customer)
    {
        this.orderedProducts = orderedProducts;
        this.customer = customer;
    }

    public  List<Integer>  getOrderedProducts() {
        return orderedProducts;
    }


    public  String getCustomer() {
        return customer;
    }
}

