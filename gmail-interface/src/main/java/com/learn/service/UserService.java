package com.learn.service;

import com.learn.gmail.bean.UserAddress;

import java.util.List;

public interface UserService {

    List<UserAddress> getUserAddressList(Integer userId);
}
