package com.sw2.assignmentTest.controllers;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sw2.assignmentTest.bsl.CompoundOrderLogic;
import com.sw2.assignmentTest.bsl.CustomerLogic;
import com.sw2.assignmentTest.models.CompoundOrder;
import com.sw2.assignmentTest.models.Customer;

@RestController
public class CompoundOrderController {

     @RequestMapping(value="/MakeCompundOrder",method = RequestMethod.POST)
    public String compundOrder(@RequestBody CompoundOrder compoundOrder)
    {
        /*System.out.println("...................................");
        System.out.println(compoundOrder.OrderOwner);
         System.out.println("...................................");*/
        return CompoundOrderLogic.MakeCompundOrder(compoundOrder);
    }

     @GetMapping(value="/GetCompundOrder")
    public List<CompoundOrder> GetcompundOrder()
    {
          System.out.println(".........................");
        System.out.println(".........................");
        try {
        List<CompoundOrder> ls = CompoundOrderLogic.getCompoundOrderData();
        return ls;
    } catch (Exception e) {
        
        System.out.println(".........................");
        System.out.println("error");
        System.out.println(".........................");
        return Collections.emptyList();
    }
    }
    
}
