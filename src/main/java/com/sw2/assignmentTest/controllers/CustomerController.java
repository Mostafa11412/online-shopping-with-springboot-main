package com.sw2.assignmentTest.controllers;

import com.sw2.assignmentTest.bsl.CompoundOrderLogic;
import com.sw2.assignmentTest.bsl.CustomerLogic;
import com.sw2.assignmentTest.models.CompoundOrder;
import com.sw2.assignmentTest.models.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController
{

    @RequestMapping(value="/customers",method = RequestMethod.POST)
    public String addCustomer(@RequestBody Customer customer)
    {
        return CustomerLogic.add(customer);
    }

    @GetMapping(value = "/allCustomers")
    public List<Customer> getCustomer() {
        return CustomerLogic.getCustomers();
    }

}
