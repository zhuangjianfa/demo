/**
 * Copyright © 2014 GZJF Corp. All rights reserved.
 * This software is proprietary to and embodies the confidential
 * technology of 深圳市大头兄弟文化传播有限公司 Corp. Possession, use, or copying
 * of this software and media is authorized only pursuant to a
 * valid written license from 深圳市大头兄弟文化传播有限公司 Corp or an authorized sublicensor.
 */
package com.owner.springcloud.customer.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.owner.common.Result;
import com.owner.common.utils.JsonMapper;
import com.owner.springcloud.provider.client.IUserClient;
import com.owner.springcloud.provider.req.UpdateUserReq;
import com.owner.springcloud.provider.resp.UserResp;

/**
 * description:消费者
 * Author	Date	Changes
 * zhuangjianfa  2018年3月26日 Created
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

    private Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
	   // Do any additional configuration here
	   return builder.build();
	}
	
    /**
     * java提供的服务直接注入
     */
    @Autowired
    private IUserClient userClient;
    
    @Autowired  
    private LoadBalancerClient load; 
    
    @Autowired 
    private RestTemplate restTemplate;
    
    /**
     * node.js服务提供者提供路径
     */
    private String nodeService="/api/v1/user/query";
    
    
    /**
     * 
     * description: node.js提供的服务获取方式 
     * createdBy:zhuangjianfa           
     * created:2018年3月29日
     */
    @RequestMapping(value="/node",method=RequestMethod.POST)
    public void nodejs() {
        ServiceInstance ss = load.choose("user");
        restTemplate.getForObject(ss.getHost()+nodeService,UserResp.class);
    }
    
    @RequestMapping(value="/update",method=RequestMethod.POST)
    @HystrixCommand(fallbackMethod = "reliable")
    public String test2(@RequestBody UpdateUserReq userReq){
    	Result<?> result = new Result<>();
    	try{
    		result = userClient.updateUser(userReq);
    		
    	}catch(Exception e){
    		//日志输出异常信息
    	    logger.error(e.getMessage());
    		//异常处理
    		result.setCode(1111);
    		result.setMessage("出错了");
    	}
    	return JsonMapper.objToJson(result);
    }
    
    public String reliable(UpdateUserReq userReq){
    	return "--------fail-----";
    }
}
