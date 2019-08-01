package com.learn.service;

import com.learn.gmail.bean.UserAddress;

import java.util.List;

public interface OrderService {

    List<UserAddress> initOrder(Integer userId);
}
