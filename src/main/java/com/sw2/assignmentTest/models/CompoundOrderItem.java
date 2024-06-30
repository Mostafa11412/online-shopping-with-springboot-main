package com.sw2.assignmentTest.models;

import java.util.ArrayList;
import java.util.List;

public class CompoundOrderItem {
    public static String productOwner;
    public static String ShippingAddress;
     public Order orderedProducts;

    public CompoundOrderItem(String productOwner,String ShippingAddress,Order orderedProducts) {
        this.productOwner=productOwner;
        this.ShippingAddress=ShippingAddress;
        this.orderedProducts = orderedProducts;
    }
}
