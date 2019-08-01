package com.learn.xml.bootxmluserserviceprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ImportResource;

@ImportResource(locations = "classpath:provider.xml")
@SpringBootApplication
@EnableHystrix
public class BootXmlUserServiceProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootXmlUserServiceProviderApplication.class, args);

        System.out.println("------provider 1 starting-------");
    }

}
