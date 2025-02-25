package cn.pangza.common.redis.runner;

import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public abstract class AbstractCache {
    public void initCache() {

    }

    public <T> T getCache(String key) {
        return null;
    }

    public void clearCache() {}
    public void clearCache(String key) {}

    public void reloadCache() {
        clearCache();
        initCache();
    }
}
