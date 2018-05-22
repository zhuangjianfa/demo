package com.owner.springcloud.provider.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 
 * @Description:demo服务启动类
 * Author	Date	Changes
 * zhuangjianfa  2018年2月27日 Created
 */
@SpringBootApplication
@ServletComponentScan
@EnableDiscoveryClient
@EnableFeignClients(basePackages={"com.owner"})
public class ProviderApplication{
	public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);   
	}
}
