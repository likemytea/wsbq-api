package com.thunisoft.wsbq.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisSonConfig {

	@Value("${redis.address}")
	private String host;

	/**
	 * 使用redisson 链接redis. 返回redisson实例
	 */
	@Bean
	public RedissonClient getRedisSonClient() {
		Config redissonConfig = new Config();

		redissonConfig.useSingleServer().setDatabase(0).setConnectionMinimumIdleSize(2).setAddress(host);
		RedissonClient redissonClient = Redisson.create(redissonConfig);
		return redissonClient;
	}

}