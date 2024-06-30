package com.sw2.assignmentTest.bsl;

import com.sw2.assignmentTest.models.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductLogic
{
    private static List<Product> products = new ArrayList<>();

    public static List<Product> getProducts() {
        return products;
    }

    public ProductLogic(List<Product> products) {
        this.products = products;
    }
    public static String add(Product p)
    {
        for (Product pd : products)
        {
            if (pd.getSerialNumber() == p.getSerialNumber())
            {
                pd.setCount(pd.getCount()+p.getCount());
                return "This is existing product , quantity incremented successfully";
            }
        }
        products.add(p);
        return "new product added successfully";
    }
    public  static Product getProduct(int serial)
    {
        for (Product pd : products)
        {
            if (pd.getSerialNumber() == serial)
            {return pd;}
        }
        return null;
    }
}
