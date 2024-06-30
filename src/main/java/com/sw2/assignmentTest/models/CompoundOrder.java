package com.sw2.assignmentTest.models;

import java.util.ArrayList;
import java.util.List;

public class CompoundOrder {
    public static String OrderOwner;
    public static List<CompoundOrderItem> orderedProducts = new ArrayList<>();

    public CompoundOrder(String OrderOwner,List<CompoundOrderItem> orderedProducts) {
        this.orderedProducts = orderedProducts;
        this.OrderOwner = OrderOwner;
    }
}
