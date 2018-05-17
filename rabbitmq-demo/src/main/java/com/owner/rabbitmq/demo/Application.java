package com.owner.rabbitmq.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 
 * @Description:rabbitmq-demo启动类
 * Author	Date	Changes
 * zhuangjianfa  2018年2月27日 Created
 */
@SpringBootApplication
//@ComponentScan(basePackages={"com.owner.rabbitmq.utils","com.owner.java.api.doc.rabbitmq"})
public class Application{
    
    
	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);  
        
	}
}
