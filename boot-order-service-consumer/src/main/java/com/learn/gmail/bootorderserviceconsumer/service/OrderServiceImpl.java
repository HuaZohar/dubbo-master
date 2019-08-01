package com.learn.gmail.bootorderserviceconsumer.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.learn.gmail.bean.UserAddress;
import com.learn.service.OrderService;
import com.learn.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    /**
     * retries = 1 : consumer 设置尝试次数,调用失败尝试一次（不包含自己本身调用的）
     * timeout = 4000 ： 调用超时4s
     */
    @Reference
    private UserService userService;

    @Override
    public List<UserAddress> initOrder(Integer userId) {
        final List<UserAddress> userAddressList = userService.getUserAddressList(userId);
        return userAddressList;
    }
}
