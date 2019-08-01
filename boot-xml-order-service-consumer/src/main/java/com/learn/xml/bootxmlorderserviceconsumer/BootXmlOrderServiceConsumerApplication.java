package com.learn.xml.bootxmlorderserviceconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations = "classpath:consumer.xml")
@EnableHystrix
public class BootXmlOrderServiceConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootXmlOrderServiceConsumerApplication.class, args);
    }

}
