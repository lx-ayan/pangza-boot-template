package cn.pangza.common.redis.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.scripting.support.ResourceScriptSource;

@Configuration
public class RedisConfig {

    @Bean
    RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnection) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
        redisTemplate.setConnectionFactory(redisConnection);
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer());
        redisTemplate.setKeySerializer(jackson2JsonRedisSerializer());
        return redisTemplate;
    }

    private Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer() {
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(Object.class);
        return jackson2JsonRedisSerializer;
    }

    @Bean
    DefaultRedisScript<Long> redisScript() {
        Resource scriptSource = new ClassPathResource("lua/limit.lua");
        DefaultRedisScript<Long> longDefaultRedisScript = new DefaultRedisScript<>();
        longDefaultRedisScript.setScriptSource(new ResourceScriptSource(scriptSource));
        longDefaultRedisScript.setResultType(Long.class);
        return longDefaultRedisScript;
    }


}
