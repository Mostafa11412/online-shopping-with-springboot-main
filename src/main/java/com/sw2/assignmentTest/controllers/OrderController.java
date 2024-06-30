package com.sw2.assignmentTest.controllers;

import com.sw2.assignmentTest.bsl.SimpleOrderLogic;
import com.sw2.assignmentTest.models.Customer;
import com.sw2.assignmentTest.models.Order;
import com.sw2.assignmentTest.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController
{

    @RequestMapping(value="/orders",method = RequestMethod.POST)
    public String addOrder(@RequestBody Order order)
    {
        return SimpleOrderLogic.MakeOrder(order);
    }

    @GetMapping(value = "/getOrder")
    public String getOrder() {
        return SimpleOrderLogic.getOrder();
    }

}
