package com.sw2.assignmentTest.controllers;

import com.sw2.assignmentTest.bsl.NotificationBsl;
import com.sw2.assignmentTest.models.Notification;
import org.springframework.web.bind.annotation.*;

import java.util.Queue;

@RestController
public class NotificationsController {

    @RequestMapping(value = "/addNotificationOne" , method = RequestMethod.POST)
    public String addNotificationOne(@RequestBody Notification request){
        return NotificationBsl.enqueue(request , 1);
    }
    @RequestMapping(value = "/addNotificationTwo" , method = RequestMethod.POST)
    public String addNotificationTwo(@RequestBody Notification request){
        return NotificationBsl.enqueue(request , 2);
    }
    @GetMapping(value = "/lastnot")
    public String lastNot(){
        return NotificationBsl.dequeue();
    }
    @GetMapping(value = "/allNotif")
    public Queue<String> allNotif(){
        return NotificationBsl.getQueue();
    }

}
