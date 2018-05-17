/**
 * Copyright © 2014 GZJF Corp. All rights reserved.
 * This software is proprietary to and embodies the confidential
 * technology of 深圳市大头兄弟文化传播有限公司 Corp. Possession, use, or copying
 * of this software and media is authorized only pursuant to a
 * valid written license from 深圳市大头兄弟文化传播有限公司 Corp or an authorized sublicensor.
 */
package com.owner.rabbitmq.demo.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.owner.rabbitmq.receiver.MqReceiver;
import com.rabbitmq.client.Channel;

/**
 * description:接收信息
 * Author	Date	Changes
 * zhuangjianfa  2018年3月9日 Created
 */
@Component
public class HelloReceiver extends MqReceiver{

    private Logger logger = LoggerFactory.getLogger(HelloReceiver.class);

    /* (non-Javadoc)
     * @see com.owner.rabbitmq.receiver.MqReceiver#onMessage(org.springframework.amqp.core.Message, com.rabbitmq.client.Channel)
     */
    @Override
    @RabbitListener(queues = "hello",containerFactory="connection")
    public void onMessage(Message message, Channel channel) throws Exception {
    	logger.info("Receiver  :{}",new String(message.getBody()));
    	channel.basicAck(message.getMessageProperties().getDeliveryTag(),true);
    }

}
