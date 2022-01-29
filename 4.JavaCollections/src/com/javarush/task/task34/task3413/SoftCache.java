package com.javarush.task.task34.task3413;

import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SoftCache {
    private Map<Long, SoftReference<AnyObject>> cacheMap = new ConcurrentHashMap<>();

    public AnyObject get(Long key) {
        SoftReference<AnyObject> softReference = cacheMap.get(key);

        if (softReference == null)
            return null;
        else
            return softReference.get();
        //напишите тут ваш код
    }

    public AnyObject put(Long key, AnyObject value) {

        SoftReference<AnyObject> oldSoftReference = cacheMap.get(key);
        AnyObject oldAnyObject = null;
        if (oldSoftReference != null) {
            oldAnyObject = oldSoftReference.get();
            oldSoftReference.clear();
        }
        SoftReference<AnyObject> softReference = cacheMap.put(key, new SoftReference<>(value));

        return oldAnyObject;

        //напишите тут ваш код
    }

    public AnyObject remove(Long key) {
        SoftReference<AnyObject> oldSoftReference = cacheMap.get(key);
        AnyObject oldAnyObject = null;
        if (oldSoftReference != null) {
            oldAnyObject = oldSoftReference.get();
            oldSoftReference.clear();
        }

        SoftReference<AnyObject> softReference = cacheMap.remove(key);

        return oldAnyObject;
        //напишите тут ваш код
    }
}