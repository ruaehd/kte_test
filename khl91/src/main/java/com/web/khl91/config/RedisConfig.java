package com.web.khl91.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

/*@Configuration*/
public class RedisConfig {

	@Bean
	public JedisConnectionFactory a() {
		JedisConnectionFactory jcf = new JedisConnectionFactory();
		
		jcf.setHostName("211.110.165.201");
		jcf.setPort(6379);
		jcf.setPassword("class901");
		jcf.setUsePool(true);
		
		return jcf;
	}
	
	@Bean StringRedisTemplate b(JedisConnectionFactory jcf) {
		StringRedisTemplate srt = new StringRedisTemplate();
		srt.setConnectionFactory(jcf);
		
		return srt;
	}
}
