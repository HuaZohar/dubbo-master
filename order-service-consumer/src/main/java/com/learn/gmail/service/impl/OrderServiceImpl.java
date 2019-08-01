package com.learn.gmail.service.impl;

import com.learn.gmail.bean.UserAddress;
import com.learn.service.OrderService;
import com.learn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private UserService userService;

    public OrderServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<UserAddress> initOrder(Integer userId) {
        final List<UserAddress> userAddressList = userService.getUserAddressList(userId);
        System.out.println(userAddressList);
        return userAddressList;
    }
}
