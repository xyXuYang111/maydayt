package com.songhaozhi.mayday.config;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.session.data.redis.RedisFlushMode;
import org.springframework.session.data.redis.RedisOperationsSessionRepository;

/**
 * @Auther: cypc
 * @Date: 2019/11/18 16:49
 * @Description:
 */
@Data
@Configuration
public class SpringSessionConfig {

    /**
     * spring在多长时间后强制使redis中的session失效,默认是1800.(单位/秒)
     */
    private int maxInactiveIntervalInSeconds = 1800;

    private String host = "127.0.0.1";

    private int port = 6379;

    private String pass = "1234qwer";

    private int db = 1;

    @Primary
    @Bean
    public RedisOperationsSessionRepository sessionRepository(RedisTemplate<Object, Object> sessionRedisTemplate) {
        RedisOperationsSessionRepository sessionRepository = new RedisOperationsSessionRepository(sessionRedisTemplate);
        sessionRepository.setDefaultMaxInactiveInterval(maxInactiveIntervalInSeconds);
        sessionRepository.setRedisFlushMode(RedisFlushMode.IMMEDIATE);
        sessionRepository.setRedisKeyNamespace("spring-session");
        return sessionRepository;
    }

    @Bean
    public RedisTemplate<Object, Object> sessionRedisTemplate() {
        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setHostName(host);
        factory.setPort(port);
        factory.setDatabase(db);
        if (StringUtils.isNotBlank(pass)) {
            factory.setPassword(pass);
        }
        factory.afterPropertiesSet();
        RedisTemplate<Object, Object> template = new RedisTemplate<Object, Object>();
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setConnectionFactory(factory);
        return template;
    }
}
