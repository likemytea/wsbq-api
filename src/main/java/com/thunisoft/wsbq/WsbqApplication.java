package com.thunisoft.wsbq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * 最高法-网上保全外网api系统
 */

@EnableFeignClients
@SpringBootApplication
@MapperScan("com.thunisoft.wsbq.mapper") // 将项目中对应的mapper类
public class WsbqApplication {

	public static void main(String[] args) {
		SpringApplication.run(WsbqApplication.class, args);
	}
}
