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
 * description:TODO
 * Author	Date	Changes
 * zhuangjianfa  2018年3月9日 Created
 */
@Component
public class HelloReceiverTwo extends MqReceiver{

	private Logger logger = LoggerFactory.getLogger(HelloReceiverTwo.class);
	
    /* (non-Javadoc)
     * @see com.owner.rabbitmq.receiver.MqReceiver#onMessage(org.springframework.amqp.core.Message, com.rabbitmq.client.Channel)
     */
    
    @RabbitListener(queues = "test",containerFactory="pushFactory")
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
      //业务是否处理完成
      boolean isSuccess = false;
      try{
         
    	  logger.info("consumer--:"+message.getMessageProperties()+":"+new String(message.getBody()));
          //完成业务处理
          isSuccess = true;
      }catch(Exception e){
        //TODO 日志记录
          
        //TODO 业务处理
          
      }finally{
          //处理完成确认消息
          if(isSuccess){
              //第一个参数:该消息的index， 
              //第二个参数：是否批量将一次性ack所有小于deliveryTag的消息。
              channel.basicAck(message.getMessageProperties().getDeliveryTag(),true);
          }else{
              //第一个参数:该消息的index
              //第二个参数：被拒绝的是否重新入队列
              channel.basicNack(message.getMessageProperties().getDeliveryTag(),true,true);
          }
      }    
        
    }
}
