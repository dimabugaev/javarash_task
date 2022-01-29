package com.javarush.task.task33.task3310.strategy;

import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public class HashMapStorageStrategy implements StorageStrategy{
    private HashMap<Long, String> data = new HashMap<>();


    @Override
    public boolean containsKey(Long key) {
        return data.containsKey(key);
    }

    @Override
    public boolean containsValue(String value) {
        return data.containsValue(value);
    }

    @Override
    public void put(Long key, String value) {
        data.put(key, value);
    }

    @Override
    public Long getKey(String value) {
        AtomicReference<Long> key = new AtomicReference<>(null);
        data.forEach((mapKey, mapValue) -> {
            if (Objects.equals(mapValue, value)) {
                key.set(mapKey);
            }
            });
        return key.get();
    }

    @Override
    public String getValue(Long key) {
        return data.get(key);
    }
}
