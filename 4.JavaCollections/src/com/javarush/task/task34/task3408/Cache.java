package com.javarush.task.task34.task3408;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<>();   //TODO add your code here

    public V getByKey(K key, Class<V> clazz) throws Exception {
        //TODO add your code here
        V obj = cache.get(key);
        if (obj == null) {
            obj = clazz.getConstructor(key.getClass()).newInstance(key);
            cache.put(key, obj);
        }
        return obj;
    }

    public boolean put(V obj) {
        //TODO add your code here
        try {
            Method method = obj.getClass().getDeclaredMethod("getKey");
            method.setAccessible(true);
            Object key = method.invoke(obj);
            cache.put((K) key, obj);
            return true;
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            return false;
        }
    }

    public int size() {
        return cache.size();
    }
}
