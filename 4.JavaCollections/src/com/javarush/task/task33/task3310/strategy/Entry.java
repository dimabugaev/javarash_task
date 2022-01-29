package com.javarush.task.task33.task3310.strategy;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

public class Entry implements Serializable {

    int hash;
    Long key;
    String value;
    Entry next;

    public Entry(int hash, Long key, String value, Entry next) {
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.next = next;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(key) ^ Objects.hashCode(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;

        if (!(obj instanceof Entry))
            return false;

        Entry e = (Entry) obj;

        return Objects.equals(key, e.getKey())
                && Objects.equals(value, e.getValue());
    }

    @Override
    public String toString() {
        return key + "=" + value;
    }

    public Long getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
