package com.owner.config.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:未添加刷新注解
 * Author	Version		Date		Changes
 * zhuangjianfa 1.0  2018年4月24日 Created
 */
@RestController
public class TestConfigServer2 {
	
	@Value("${swagger.enable}")
	public boolean abc;
	
	@Value("${swagger.enable}")
	public static boolean dfg;
	
	@RequestMapping(path="/test2/get",method=RequestMethod.GET)
	public String test(){
		return "abc="+abc+"\r\n"+"dfg="+dfg;
	}
}
