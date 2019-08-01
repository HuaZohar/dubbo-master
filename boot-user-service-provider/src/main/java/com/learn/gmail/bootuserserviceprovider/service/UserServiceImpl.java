package com.learn.gmail.bootuserserviceprovider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.learn.gmail.bean.UserAddress;
import com.learn.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author zzh
 * @Service 暴露接口  注意所在jar包
 */
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
//            TimeUnit.SECONDS.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        return result;
    }
}
