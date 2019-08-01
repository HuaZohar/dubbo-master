package com.learn.gmail;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Provider_App {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("provider.xml");

        ioc.start();

        System.out.println("provider starting......");

        System.in.read();
    }
}
