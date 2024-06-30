package com.sw2.assignmentTest.bsl;

public class TemplateTwo implements Template{

    @Override
    public String generateString() {
        return "Hello {name}, We are glad to inform you that your booking of {product} is confirmed, See you soon :)";
    }
}
