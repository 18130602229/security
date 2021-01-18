package com.bglemon.blue.taste.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @Author:zhuchuanshun
 * @Description: 缓存工具类
 * @Date: 2019/4/11 16:27
 * @Modificd:
 */
@Service
public class RedisUtil {
    @Autowired
    private RedisTemplate redisTemplate;
    private final static String PROJECT_KEY ="blackview-admin:";
    private final static String FLOW_RECHARGE ="flow-recharge";
    /**
     * 判断缓存中是否有对应的value
     *
     * @param key
     * @return
     */
    public boolean exists(final String key) {
        return redisTemplate.hasKey(PROJECT_KEY+key);
    }

    /**
     * 删除对应的value
     *
     * @param key
     */
    public void remove(final String key) {
        if (exists(key)) {
            redisTemplate.delete(PROJECT_KEY+key);
        }
    }

    /**
     * 读取缓存
     *
     * @param key
     * @return
     */
    public String getString(final String key) {
        Object result = null;
        ValueOperations<String, Object> operations = redisTemplate
                .opsForValue();
        result = operations.get(PROJECT_KEY+key);
        return result ==null?"":result.toString();
    }
    /**
     * 写入缓存设置时效时间
     * @param key
     * @param value
     * @param expireTime 单位 秒
     * @return
     */
    public boolean setObj(String key, Object value, Long expireTime) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    /**
     * 读取缓存
     * @param key
     * @return
     */
    public Object getCollection(String key) {
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        return operations.get(key);
    }
    /**
     * 读取缓存
     *
     * @param key
     * @return
     */
    public String get(final String key) {
        Object result = null;
        ValueOperations<String, Object> operations = redisTemplate
                .opsForValue();
        result = operations.get(key);
        return result ==null?"":result.toString();
    }
    public void set(final String key, final String value) {
        ValueOperations<String, Object> operations = redisTemplate.opsForValue();
        operations.set(key,value);
    }
    public void setString(final String key, final String value) {
        ValueOperations<String, Object> operations = redisTemplate.opsForValue();
        operations.set(PROJECT_KEY+key,value);
    }
    public void setInt(String key, int value) {
        ValueOperations<String, Object> operations = redisTemplate.opsForValue();
        operations.set(PROJECT_KEY+key,value);
    }

    public int getInt( String key) {
        Object result = null;
        ValueOperations<String, Object> operations = redisTemplate
                .opsForValue();
        result = operations.get(FLOW_RECHARGE+key);
        return result ==null?0:(int)result;
    }

    /**
     * 获取缓存中包含key的所有键值
     * @author      wangyanhong
     * @param
     * @return
     * @exception
     * @date        2019/8/13 17:13
     */
    public Set<String> getKeys(String key) {
        Set<String> keys= redisTemplate.keys(PROJECT_KEY+key + "*");
        return keys;
    }

    public boolean setObject(final String key, Object value) {
        boolean result = false;
        try {
            addValue(key, value, 0);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 写入缓存
     *
     * @param key
     * @param value
     * @param expireTime
     * @return
     */
    public boolean setObject(final String key, Object value, Long expireTime) {
        boolean result = false;
        try {
            addValue(PROJECT_KEY+key, value, expireTime);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public void addValue(String key, Object value, long expireTime){
        //RootRedisThread RootRedisThread = new RootRedisThread(rootRedisTemplate,key,value,expireTime);//向主的redis节点写信息
        // RootRedisThread.start();//为什么要单独启动一个线程，因为主的redis如果连接有问题，在向主的redis里面set值时会等待半天，一直到超时失败，为了不影响正常本地redis读写，单独启动一个线程.最好的办法是获取rootRedisTemplate连接状态，连接未成功不执行set操作，但是暂时还没找到判断rootRedisTemplate是否连接成功的属性值，暂时这样做

        ValueOperations<String, Object> operations = redisTemplate.opsForValue();
        operations.set(PROJECT_KEY+key, value);
        if(expireTime > 0)redisTemplate.expire(PROJECT_KEY+key, expireTime, TimeUnit.SECONDS);
    }
}
