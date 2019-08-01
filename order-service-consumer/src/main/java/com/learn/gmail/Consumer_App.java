package com.learn.gmail;

import com.learn.service.OrderService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Consumer_App {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
        context.start();

        System.out.println("consumer starting......");

        OrderService orderService = (OrderService) context.getBean("orderServiceImpl");

        orderService.initOrder(1);

        System.in.read();
    }
}
