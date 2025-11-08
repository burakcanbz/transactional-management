package com.example.notification.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notification")
public class NotificationController
{

    @GetMapping("/status")
    public String NotificationStatus(){
        return "OK";
    }

    @GetMapping("/history/{id}")
    public String NotificationHistoryByUserId(@PathVariable Integer id){
        return "Notification History By UserId";
    }

}
