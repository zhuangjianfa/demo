/**
 * Copyright © 2014 GZJF Corp. All rights reserved.
 * This software is proprietary to and embodies the confidential
 * technology of 深圳市大头兄弟文化传播有限公司 Corp. Possession, use, or copying
 * of this software and media is authorized only pursuant to a
 * valid written license from 深圳市大头兄弟文化传播有限公司 Corp or an authorized sublicensor.
 */
package com.owner.java.api.doc.gen;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.owner.rabbitmq.demo.Application;
import com.owner.rabbitmq.demo.message.HelloSender;

/**
 * description:TODO
 * Author	Date	Changes
 * zhuangjianfa  2018年3月9日 Created
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = WebEnvironment.DEFINED_PORT)
public class SendTest {
    
    @Autowired
    private HelloSender helloSender;
    
    @Test
    public void test(){
        for(int i = 0;i < 100 ; i++){
            helloSender.test(i);
            helloSender.test2(i);
            helloSender.hello(i);
        }
    }
}
