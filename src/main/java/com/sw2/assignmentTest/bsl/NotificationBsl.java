package com.sw2.assignmentTest.bsl;

import com.sw2.assignmentTest.models.Customer;
import com.sw2.assignmentTest.models.Notification;
import com.sw2.assignmentTest.models.Product;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

@Service
public class NotificationBsl {
    public static Queue<String> queue = new LinkedList<>();

    public static String enqueue(Notification request , int template) {
        List<Customer> customers= CustomerLogic.getCustomers();
        List<Product> products= ProductLogic.getProducts();
        boolean productFound = false;
        boolean customerFound = false;
        for (Customer c : customers)
        {
            if (Objects.equals(request.customer, c.getName())) {
                customerFound = true;
                break;
            }
        }
        if(!customerFound){
            return "This customer Not found";
        }
        for (Product p : products)
        {
            if (Objects.equals(request.productSerial, p.getSerialNumber())) {
                productFound = true;
                break;
            }
        }
        if(!productFound){
            return "This product Not found";
        }
        if(template == 1) {
            Template template1 = new TemplateOne();
            String notification = template1.generateString();
            notification = notification.replace("{name}", request.customer).replace("{product}", ProductLogic.getProduct(request.productSerial).getName());
            queue.add(notification);
            System.out.println("Notification added: " + notification);
            return "notification added successfully";
        }
        else{
            Template template2 = new TemplateTwo();
            String notification = template2.generateString();
            notification = notification.replace("{name}", request.customer).replace("{product}", ProductLogic.getProduct(request.productSerial).getName());
            queue.add(notification);
            System.out.println("Notification added: " + notification);
            return "notification added successfully";
        }
    }

    public static String dequeue() {
        return queue.poll();
    }
    public static Queue<String>getQueue(){
        return queue;
    }


}
