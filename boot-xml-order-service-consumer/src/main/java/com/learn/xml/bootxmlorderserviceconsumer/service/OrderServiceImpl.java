package com.learn.xml.bootxmlorderserviceconsumer.service;

import com.google.common.collect.Lists;
import com.learn.gmail.bean.UserAddress;
import com.learn.service.OrderService;
import com.learn.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    /**
     * retries = 1 : consumer 设置尝试次数,调用失败尝试一次（不包含自己本身调用的）
     * timeout = 4000 ： 调用超时4s
     */
    @Autowired
    private UserService userService;

    @Override
    @HystrixCommand(fallbackMethod = "fallbackInitOrder")
    public List<UserAddress> initOrder(Integer userId) {
        final List<UserAddress> userAddressList = userService.getUserAddressList(userId);
        return userAddressList;
    }

    public List<UserAddress> fallbackInitOrder(Integer userId){
        System.out.println("△△△△△△fallbackInitOrder----");
        return Lists.newArrayList();
    }
}
