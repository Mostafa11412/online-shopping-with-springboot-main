package com.sw2.assignmentTest.models;

public class Notification {
    public String customer;
    public Integer productSerial;

    public String getCustomer() {
        return customer;
    }

    public Integer getProduct() {
        return productSerial;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public void setProduct(Integer productSerial) {
        this.productSerial = productSerial;
    }

}
