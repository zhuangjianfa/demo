#config-client-demo
1.加入pom：
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-config</artifactId>
</dependency>
 <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-bus-amqp</artifactId>
</dependency>

2.bootstrap.yml
#配置服务地址
spring.cloud.config.uri: http://localhost:96
#配置服务的application路径
spring.application.name: config-client
#配置文件名前缀
spring.cloud.config.name: config-client
#配置服务区分环境地址
spring.cloud.config.profile: dev

3.在需要使用刷新配置的类上添加注解,示例中两个controller一个添加了注解，一个没添加，可以看出效果
@RefreshScope
