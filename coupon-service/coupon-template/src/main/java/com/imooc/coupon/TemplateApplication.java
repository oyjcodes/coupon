package com.imooc.coupon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * <h1>模板微服务的启动入口</h1>
 * Created by oyj.
 */
@EnableScheduling   //定时任务
@EnableJpaAuditing   //利用jpa
@EnableEurekaClient //可向EurekaService发起注册
@SpringBootApplication  //当前应用为SpringBoot
public class TemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(TemplateApplication.class,args);
    }
}
