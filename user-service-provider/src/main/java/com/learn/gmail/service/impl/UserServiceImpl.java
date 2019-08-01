package com.learn.gmail.service.impl;

import com.learn.gmail.bean.UserAddress;
import com.learn.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public List<UserAddress> getUserAddressList(Integer userId) {

        UserAddress userAddress1 = new UserAddress(1, "wuhan", 11);
        UserAddress userAddress2 = new UserAddress(1, "wuhan", 11);

        List<UserAddress> result = new ArrayList<>();
        result.add(userAddress1);
        result.add(userAddress2);

        System.out.println("provider---UserServiceImpl---");

//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        return result;
    }
}
