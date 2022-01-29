package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/

public class CustomTree extends AbstractList<String> implements Cloneable, Serializable{

    Entry<String> root;
    List<Entry<String>> dataTree;

    public CustomTree() {
        this.root = new Entry<>("0");
        this.dataTree = new ArrayList<>();
        this.dataTree.add(root);
    }

    public String getParent(String s){
        for(Entry<String> element: dataTree){
            if (element.elementName.equals(s))
                return element.parent.elementName;
        }
        return null;
    }


    @Override
    public boolean remove(Object o){
        if (!(o instanceof String)){
            throw new UnsupportedOperationException();
        }

        for (Entry<String> element: dataTree){
            if (element.elementName.equals((String) o)) {
                //if (element == element.parent.leftChild)
                deleteEntry(element);
                actualizeChild();
                return true;
            }
        }

        return false;
    }

    private void deleteEntry(Entry<String> entry){


        if (entry.rightChild!=null){
            deleteEntry(entry.rightChild);
        }
        if (entry.leftChild!=null){
            deleteEntry(entry.leftChild);
        }
        if (entry.parent.rightChild == entry)
            entry.parent.rightChild = null;
        if (entry.parent.leftChild == entry)
            entry.parent.leftChild = null;
        dataTree.remove(entry);
    }

    @Override
    public boolean add(String s) {
        //int index = 0;
        for (int index = 0; index < dataTree.size(); index++) {
            if (dataTree.get(index).isAvailableToAddChildren()){
                Entry<String> newChild = dataTree.get(index).add(s);
                dataTree.add(newChild);
                return true;
            }
        }
        return false;
    }

    private void actualizeChild(){
        boolean isNoMoreChild = true;
        for (Entry<String> element: dataTree){
            if (element.isAvailableToAddChildren())
                isNoMoreChild = false;
        }

        if (isNoMoreChild) {
            for (Entry<String> element : dataTree) {
                if (element.leftChild == null)
                    element.availableToAddLeftChildren = true;
                if (element.rightChild == null)
                    element.availableToAddRightChildren = true;
            }
        }
    }


    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return dataTree.size() -1 ;
    }



    static class Entry<T> implements Serializable{

        String elementName;
        boolean availableToAddLeftChildren;
        boolean availableToAddRightChildren;
        Entry<T> parent;
        Entry<T> leftChild;
        Entry<T> rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }

        public boolean isAvailableToAddChildren(){
            return availableToAddLeftChildren || availableToAddRightChildren;
        }

        public Entry<T> add(String name){
            if (availableToAddLeftChildren) {
                leftChild = new Entry<T>(name);
                leftChild.parent = this;
                availableToAddLeftChildren = false;
                return leftChild;
            }else if (availableToAddRightChildren){
                rightChild = new Entry<T>(name);
                rightChild.parent = this;
                availableToAddRightChildren = false;
                return rightChild;
            }
            return null;
        }
    }
}
