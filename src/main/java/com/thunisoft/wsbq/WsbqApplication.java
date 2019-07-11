package com.thunisoft.wsbq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ImportResource;

/**
 * 最高法-网上保全外网api系统 
 */

@EnableFeignClients
@SpringBootApplication
@MapperScan("com.thunisoft.wsbq.mapper") // 将项目中对应的mapper类
@ImportResource(locations = { "classpath:activiti.cfg.xml" }) // 引入xml配置文件
public class WsbqApplication {

	public static void main(String[] args) {
		SpringApplication.run(WsbqApplication.class, args);
	}
}
