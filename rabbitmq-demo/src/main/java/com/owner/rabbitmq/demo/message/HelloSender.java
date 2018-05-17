/**
 * Copyright © 2014 GZJF Corp. All rights reserved.
 * This software is proprietary to and embodies the confidential
 * technology of 深圳市大头兄弟文化传播有限公司 Corp. Possession, use, or copying
 * of this software and media is authorized only pursuant to a
 * valid written license from 深圳市大头兄弟文化传播有限公司 Corp or an authorized sublicensor.
 */
package com.owner.rabbitmq.demo.message;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.stereotype.Component;

import com.owner.rabbitmq.enums.ExchangeTypeEnum;
import com.owner.rabbitmq.model.MessageBuilder;
import com.owner.rabbitmq.sender.MqSender;


/**
 * description:消息发送
 * Author	Date	Changes
 * zhuangjianfa  2018年3月9日 Created
 */
@Component
public class HelloSender extends MqSender{

	private Logger logger = LoggerFactory.getLogger(HelloSender.class);
	
    @Resource(name="rabbitTempleate")
    private RabbitTemplate rabbitTemplate;
    
    @Resource(name="pushRabbitTempleate")
    private RabbitTemplate pushRabbitTempleate;
    public void test(int i){
        MessageBuilder builder = new MessageBuilder(rabbitTemplate, "direct.test", "test-c"+i, ExchangeTypeEnum.DIRECT);
        send(builder);
    }
    
    public void hello(int i){
        MessageBuilder builder = new MessageBuilder(rabbitTemplate, "direct.hello", "hello"+i, ExchangeTypeEnum.DIRECT);
        send(builder);
    }
    
    public void test2(int i){
        MessageBuilder builder = new MessageBuilder(pushRabbitTempleate, "direct.test", "test-p"+i, ExchangeTypeEnum.DIRECT);
        send(builder);
    }
    
    /* (non-Javadoc)
     * @see com.owner.rabbitmq.sender.MqSender#confirm(org.springframework.amqp.rabbit.support.CorrelationData, boolean, java.lang.String)
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
       if(ack){
    	   logger.info("success id="+correlationData.getId());
       }else{
    	   logger.info("faild id="+correlationData.getId());
       }
    }

}
