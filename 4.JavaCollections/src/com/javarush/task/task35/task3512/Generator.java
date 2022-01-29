package com.javarush.task.task35.task3512;


public class Generator<T> {
    private Class<T> clazz;
    T newInstance() throws InstantiationException, IllegalAccessException {
        //return new T();
        return clazz.newInstance();
    }

    public Generator(Class<T> clazz) {
        this.clazz = clazz;
    }
}
