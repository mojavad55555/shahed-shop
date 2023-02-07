package com.shahed.shop;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.shahed.shop"})
@EnableCaching
@EnableScheduling
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ShopApplication {

    @Bean
    public Mapper mapper() {
        return new DozerBeanMapper();
    }
    public static void main(String[] args) {
        SpringApplication.run(ShopApplication.class, args);
    }

}
