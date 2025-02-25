package cn.pangza.common.redis.utils;

import cn.pangza.common.redis.service.RedisService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RedisShareLockUtil {

    @Autowired
    RedisService redisService;

    private static final long TIME_OUT = 1000L;

    public boolean lock(String lockKey, String requestId, long time) {
        if(StringUtils.isBlank(lockKey) || StringUtils.isBlank(requestId) || time <= 0) {
            throw new RuntimeException("分布式锁加锁参数异常");
        }
        // 获取当前时间
        long currentTime = System.currentTimeMillis();
        // 结束时间
        long outTime = currentTime + TIME_OUT;
        boolean result = false;
        while (currentTime < outTime) {
            result = redisService.setNx(lockKey, requestId, time);

            if(result) return result;

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            currentTime = System.currentTimeMillis();
        }
        return result;
    }

    public boolean unlock(String lockKey, String requestId) {
        if(StringUtils.isBlank(lockKey) || StringUtils.isBlank(requestId)) {
            throw new RuntimeException("分布式锁加锁参数异常");
        }
        String value = redisService.get(lockKey);
        if(value.equals(requestId))  {
            return redisService.remove(lockKey);
        }
        return false;
    }

    public boolean tryLock(String lockKey, String requestId, long time) {
        if(StringUtils.isBlank(lockKey) || StringUtils.isBlank(requestId)) {
            throw new RuntimeException("分布式锁加锁参数异常");
        }

        return redisService.setNx(lockKey, requestId, time);
    }
}
