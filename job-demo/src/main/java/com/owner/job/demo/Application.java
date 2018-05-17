package com.owner.job.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/**
 * 
 * description:job-demo启动类
 * Author	Date	Changes
 * zhuangjianfa  2018年4月9日 Created
 */
@SpringBootApplication
@ComponentScan({"com.owner.job"})
public class Application{
    
    
	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);  
        
	}
}
