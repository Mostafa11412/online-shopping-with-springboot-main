package com.sw2.assignmentTest.bsl;

public class TemplateOne implements Template{

    @Override
    public String generateString() {
        return "Dear {name}, your booking of {product} is confirmed. Thanks for using store :)";
    }
}
