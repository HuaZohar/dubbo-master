package com.learn.xml.bootxmluserserviceprovider.service;

import com.learn.gmail.bean.UserAddress;
import com.learn.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserServiceImpl implements UserService {
    @Override
    public List<UserAddress> getUserAddressList(Integer userId) {

        UserAddress userAddress1 = new UserAddress(1, "wuhan", 11);
        UserAddress userAddress2 = new UserAddress(1, "wuhan", 11);

        List<UserAddress> result = new ArrayList<>();
        result.add(userAddress1);
        result.add(userAddress2);

        System.out.println("provider---UserServiceImpl---");

        if (new Random().nextInt() < 0) {
            throw new RuntimeException();
        }

        return result;
    }
}
