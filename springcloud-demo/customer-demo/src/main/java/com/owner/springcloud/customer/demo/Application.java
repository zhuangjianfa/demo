package com.owner.springcloud.customer.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * @Description:推送服务启动类
 * Author	Date	Changes
 * zhuangjianfa  2018年2月27日 Created
 */
@SpringBootApplication
@ServletComponentScan
@EnableDiscoveryClient
@ComponentScan
@EnableFeignClients(basePackages={"com.owner"})
@EnableCircuitBreaker
public class Application{
	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);   
	}
	
}
