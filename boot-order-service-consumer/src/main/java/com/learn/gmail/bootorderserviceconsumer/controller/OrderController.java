package com.learn.gmail.bootorderserviceconsumer.controller;

import com.learn.gmail.bean.UserAddress;
import com.learn.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/getUserList")
    public List<UserAddress> getUserList(@RequestParam("uid") Integer userId){
        return orderService.initOrder(userId);
    }
}
