/**
 * Copyright © 2014 GZJF Corp. All rights reserved. This software is proprietary
 * to and embodies the confidential technology of 深圳市大头兄弟文化传播有限公司 Corp.
 * Possession, use, or copying of this software and media is authorized only
 * pursuant to a valid written license from 深圳市大头兄弟文化传播有限公司 Corp or an
 * authorized sublicensor.
 */
package com.owner.rabbitmq.demo.message;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * description:rabbitmq配置
 * Author	Date	Changes
 * zhuangjianfa  2018年3月9日 Created
 */
@Configuration
public class RabbitConfig {
    
    
    @Bean(name = "connectionFactory")
    public ConnectionFactory connectionFactory(@Value("${spring.rabbitmq.addresses}") String addresses,
                                                   @Value("${spring.rabbitmq.username}") String username,
                                                   @Value("${spring.rabbitmq.password}") String password,
                                                   @Value("${spring.rabbitmq.virtual-host}") String virtualHost) {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setAddresses(addresses);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        connectionFactory.setVirtualHost(virtualHost);
        return connectionFactory;
    }
    
    @Bean(name = "rabbitTempleate")
    public RabbitTemplate rabbitTemplate(@Qualifier("connectionFactory")ConnectionFactory connectionFactory) {
        RabbitTemplate pushRabbitTemplate = new RabbitTemplate(connectionFactory);
        return pushRabbitTemplate;
    }

    @Bean(name = "connection")
    public SimpleRabbitListenerContainerFactory connection(SimpleRabbitListenerContainerFactoryConfigurer configurer,
                                                            @Qualifier("connectionFactory") ConnectionFactory connectionFactory,
                                                            @Value("${spring.rabbitmq.amqpcontainer.prefetch}") Integer prefetch) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        configurer.configure(factory, connectionFactory);
        factory.setPrefetchCount(prefetch);
        factory.setConcurrentConsumers(2);
        return factory;
    }

    
    @Bean(name = "pushConnectionFactory")
    public ConnectionFactory pushConnectionFactory(@Value("${spring.rabbitmq.push.addresses}") String addresses,
                                                   @Value("${spring.rabbitmq.push.username}") String username,
                                                   @Value("${spring.rabbitmq.push.password}") String password,
                                                   @Value("${spring.rabbitmq.push.virtual-host}") String virtualHost) {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setAddresses(addresses);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        connectionFactory.setVirtualHost(virtualHost);
        return connectionFactory;
    }

    @Bean(name = "pushRabbitTempleate")
    public RabbitTemplate pushRabbitTemplate(@Qualifier("pushConnectionFactory") ConnectionFactory connectionFactory) {
        RabbitTemplate pushRabbitTemplate = new RabbitTemplate(connectionFactory);
        return pushRabbitTemplate;
    }

    @Bean(name = "pushFactory")
    public SimpleRabbitListenerContainerFactory pushFactory(SimpleRabbitListenerContainerFactoryConfigurer configurer,
                                                            @Qualifier("pushConnectionFactory") ConnectionFactory connectionFactory,
                                                            @Value("${spring.rabbitmq.push.listener.acknowledge-mode}") AcknowledgeMode acknowledgeMode) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        configurer.configure(factory, connectionFactory);
        factory.setAcknowledgeMode(acknowledgeMode);
        return factory;
    }

}
