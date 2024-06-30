package com.sw2.assignmentTest.bsl;

import com.sw2.assignmentTest.models.Customer;
import com.sw2.assignmentTest.models.Order;
import com.sw2.assignmentTest.models.Product;

import java.util.List;
import java.util.Objects;
import java.util.Random;

public class SimpleOrderLogic
{
    Random random = new Random();
    public static String MakeOrder(Order order)
    {
        int totalSum = 0;
        boolean f =false;
        boolean f2 =false;

        Random random = new Random();
        List<Product> products= ProductLogic.getProducts();
        List<Customer> customers= CustomerLogic.getCustomers();
        for (Customer c : customers)
        {
            if (Objects.equals(order.getCustomer(), c.getName()))
            {
                f2= true;
                break;

            }

        }
        if (!f2)
        {
            return "Customer : "+order.getCustomer()+" Not available.";
        }


        for (int pserial : order.orderedProducts)
        {
            for (Product product : products)
            {
                if (pserial == product.getSerialNumber())
                {
                    f= true;
                    break;

                }

            }
            if (!f)
            {
                return "product with this serial : "+pserial+" Not available in our store";
            }
            if (ProductLogic.getProduct(pserial).getCount() >0)
            {ProductLogic.getProduct(pserial).setCount(ProductLogic.getProduct(pserial).getCount()-1);
                totalSum += ProductLogic.getProduct(pserial).getPrice();}
            else
            {
                return "this product : " + ProductLogic.getProduct(pserial).getName() + " is Out of stock right now";
            }

        }
        int shippingFees = random.nextInt(10) + 1;
        totalSum += shippingFees;
        if(CustomerLogic.getCustomer(order.customer).getBalance() > totalSum) {
            CustomerLogic.getCustomer(order.customer).setBalance(CustomerLogic.getCustomer(order.customer).getBalance() - totalSum);
        }
        else {return "Customer has No enough Balance";}
        return "Order placed Succefuly";
    }
    public static String getOrder() {
        StringBuilder products = new StringBuilder();
        for (int i : Order.orderedProducts)
        {
            products.append(ProductLogic.getProduct(i).getName());

            products.append(" , ");
        }
        return "Customer name : " + Order.customer+
                "\nList of ordered products are : " + products;

    }
}
