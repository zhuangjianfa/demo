# rabbitmq-demo
1.引用：
<dependency>
	<groupId>com.owner</groupId>
	<artifactId>owner-rabbitmq</artifactId>
	<version>0.0.1</version>
</dependency>
说明：
1.只使用一个rabbitmq或vitrual host配置,则不需要添加RabbitConfig,配置文件application.yml也只保留默认配置即可，所有注解中有containerFactory的都去除。
2.如果是多个rabbitmq或vitrual host配置,则需要自己添加RabbitConfig配置管理类
3.发送者继承MqSender，消费者继承MqReceiver，相关方法上添加对应的注解，具体参数示例代码。
4.消费确认类型
//扔掉消息
channel.BasicReject(result.DeliveryTag, false);
//退回消息
channel.BasicReject(result.DeliveryTag, true);
//批量退回或删除,中间的参数 是否批量 true是/false否 (也就是只一条)
channel.BasicNack(result.DeliveryTag, true, true);
//补发消息 true退回到queue中/false只补发给当前的consumer
channel.BasicRecover(true);
5.批量确认的情况，如每次会往echannel放10条信息，你可以不每次消费一条提交，一直到10条都处理完了一次确认或拒绝。当10条消费完才会再放10条数据到缓冲区。如果一条一条提交就会每确认一条，会再重新放一条在缓冲区。根据具体业务做具体操作。
6.springboot rabbitmq配置
spring.rabbitmq.addresses指定client连接到的server的地址，多个以逗号分隔.
spring.rabbitmq.dynamic是否创建AmqpAdmin bean. 默认为: true)
spring.rabbitmq.host指定RabbitMQ host.默认为: localhost)
spring.rabbitmq.listener.acknowledge-mode指定Acknowledge的模式.
spring.rabbitmq.password指定broker的密码.
spring.rabbitmq.port指定RabbitMQ 的端口，默认: 5672)
spring.rabbitmq.requested-heartbeat指定心跳超时，0为不指定.
spring.rabbitmq.ssl.enabled是否开始SSL，默认: false)
spring.rabbitmq.ssl.key-store指定持有SSL certificate的key store的路径
spring.rabbitmq.ssl.key-store-password指定访问key store的密码.
spring.rabbitmq.ssl.trust-store指定持有SSL certificates的Trust store.
spring.rabbitmq.ssl.trust-store-password指定访问trust store的密码.
spring.rabbitmq.username指定登陆broker的用户名.
spring.rabbitmq.virtual-host指定连接到broker的Virtual host.
#springboot2.0后无以下配置了
#spring.rabbitmq.listener.auto-startup是否在启动时就启动mq，默认: true)
#spring.rabbitmq.listener.concurrency指定最小的消费者数量.
#spring.rabbitmq.listener.max-concurrency指定最大的消费者数量.
#spring.rabbitmq.listener.prefetch指定一个请求能处理多少个消息，如果有事务的话，必须大于等于transaction数量.
#spring.rabbitmq.listener.transaction-size指定一个事务处理的消息数量，最好是小于等于prefetch的数量.