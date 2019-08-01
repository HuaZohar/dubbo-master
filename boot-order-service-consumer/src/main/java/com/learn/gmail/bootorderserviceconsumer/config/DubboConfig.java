package com.learn.gmail.bootorderserviceconsumer.config;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.MonitorConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * dubbo:
 *   application:
 *     name: boot-order-service-consumer
 *   registry:
 *     address:  192.168.43.177:2181
 *     protocol: zookeeper
 *   monitor:
 *     protocol: registry
 */
@Configuration
public class DubboConfig {
    @Bean
    public ApplicationConfig applicationConfig(){
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("boot-order-service-consumer");
        return applicationConfig;
    }

    @Bean
    public RegistryConfig registryConfig(){
        final RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("192.168.43.177:2181");
        registryConfig.setProtocol("zookeeper");
        return registryConfig;
    }

    @Bean
    public MonitorConfig monitorConfig(){
        MonitorConfig monitorConfig = new MonitorConfig();
        monitorConfig.setProtocol("registry");
        return monitorConfig;
    }

}
