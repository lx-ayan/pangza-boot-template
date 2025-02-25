package cn.pangza.common.redis.runner;

import cn.pangza.common.redis.utils.RedisSpringContextUtil;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class InitCache implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        ApplicationContext applicationContext = RedisSpringContextUtil.getApplicationContext();
        // 获取使用该抽象类
        Map<String, AbstractCache> beansOfType = applicationContext.getBeansOfType(AbstractCache.class);
        if(beansOfType.isEmpty()) {
            return;
        }
        // 获取容器内 initCache
        for (Map.Entry<String, AbstractCache> cacheEntry : beansOfType.entrySet()) {
            AbstractCache bean = (AbstractCache) RedisSpringContextUtil.getBean(cacheEntry.getValue().getClass());
            bean.initCache();
        }
    }
}
