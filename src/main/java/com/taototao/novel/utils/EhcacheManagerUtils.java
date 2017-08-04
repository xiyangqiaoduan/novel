package com.taototao.novel.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Component;

/**
 * ehcache 工具类
 *
 * @author yangcb
 * @create 2017-08-04 10:26
 **/
@Component
public class EhcacheManagerUtils {

    @Autowired
    private EhCacheCacheManager cacheManager;


    /**
     * 放入缓存
     *
n     * @param key       缓存key
     * @param value     缓存的值
     */
    public void put(String cacheName, String key, Object value) {
        Cache cache = getCache(cacheName);
        cache.put(key, value);
    }


    public  Object get(String cacheName, String key){
        Cache cache = getCache(cacheName);
        return cache.get(key);
    }


    public <T> T get(String cacheName, String key, Class<T> clazz) {
        Cache cache = getCache(cacheName);
        return cache.get(key, clazz);
    }

    public void remove(String cacheName, String key) {
        Cache cache = getCache(cacheName);
        cache.evict(key);
    }

    public void clear(String cacheName){
        Cache cache = getCache(cacheName);
        cache.clear();;
    }




    private Cache getCache(String cacheName) {
        return  cacheManager.getCache(cacheName);
    }


}
