package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {
    private static final Object PRESENT = new Object();
    private transient HashMap<E,Object> map;

    public AmigoSet() {
        map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        map = new HashMap<>(Math.max(16, (int) (collection.size()/.75f) + 1));
        addAll(collection);
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();

        int capacity = HashMapReflectionHelper.callHiddenMethod(map,"capacity");
        float loadFactor = HashMapReflectionHelper.callHiddenMethod(map,"loadFactor");
        out.writeInt(capacity);
        out.writeFloat(loadFactor);

        out.writeInt(map.keySet().size());
        for (E key: map.keySet()){
            out.writeObject(key);
        }


    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException{
        in.defaultReadObject();
        int capacity = in.readInt();
        float loadFactor = in.readFloat();
        map = new HashMap<>(capacity, loadFactor);
        int size = in.readInt();
        for (int i = 0; i < size; i++) {
            add((E) in.readObject());
        }
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public boolean add(E e) {
        return map.put(e, PRESENT)==null;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        for (E key: c){
            add(key);
        }
        return true;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o) != null;
    }

    @Override
    public Object clone() {

        try {
            AmigoSet<E> o = new AmigoSet<>();
            o.map = (HashMap<E, Object>) map.clone();
            return o;
        } catch (Exception e) {
            throw new InternalError();
        }
    }
}
