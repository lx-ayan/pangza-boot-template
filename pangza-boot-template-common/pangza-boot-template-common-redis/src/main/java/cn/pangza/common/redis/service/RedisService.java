package cn.pangza.common.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class RedisService {

    @Autowired
    RedisTemplate redisTemplate;

    public boolean set(String key, String value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean set(String key, Object value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean set(String key, String value, long time) {
        try {
            redisTemplate.opsForValue().set(key, value, Duration.ofSeconds(time));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean set(String key, Object value, long time) {
        try {
            redisTemplate.opsForValue().set(key, value, Duration.ofSeconds(time));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean setObjectMillisTime(String key, Object value, long time) {
        try {
            redisTemplate.opsForValue().set(key, value, Duration.ofMillis(time));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public String get(String key) {
        return (String) redisTemplate.opsForValue().get(key);
    }

    public Object getObject(String key) {
        return (Object) redisTemplate.opsForValue().get(key);
    }

    public boolean setNx(String lockKey, String requestId, long time) {
        return redisTemplate.opsForValue().setIfAbsent(lockKey, requestId, Duration.ofMillis(time));
    }

    public boolean remove(String lockKey) {
        return redisTemplate.delete(lockKey);
    }
}
