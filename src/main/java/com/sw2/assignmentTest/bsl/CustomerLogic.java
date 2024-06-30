package com.sw2.assignmentTest.bsl;

import com.sw2.assignmentTest.models.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CustomerLogic {
    public static List<Customer>Customers = new ArrayList<>();

    public static List<Customer> getCustomers() {
        return Customers;
    }

    public static String add(Customer customer){
        for(Customer c : Customers){
            if(Objects.equals(c.getName(), customer.getName())){
                return "this Customer already exists";
            }
        }
        Customers.add(customer);
        return "Customer Added successfully";
    }

    public static Customer getCustomer(String name){
        for(Customer customer : Customers){
            if(Objects.equals(customer.getName(), name)){
                return customer;
            }
        }
        return null;
    }
}
