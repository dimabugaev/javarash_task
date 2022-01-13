package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Human implements Alive{
    private static int nextId = 0;
    private int id;
    protected int age;
    protected String name;
    //protected int course;

    //protected int[] size;
    protected Size size;

    //protected boolean isSoldier;

//    public static final BloodGroup FIRST = BloodGroup.first();
//    public static final BloodGroup SECOND = BloodGroup.second();
//    public static final BloodGroup THIRD = BloodGroup.third();
//    public static final BloodGroup FOURTH = BloodGroup.fourth();
    private BloodGroup bloodGroup;

    private List<Human> children = new ArrayList<>();

    public class Size{
        public int height;
        public int weight;
    }

    public void setBloodGroup(BloodGroup code) {
        bloodGroup = code;
    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }


    public Human(String name, int age) {
        this.name = name;
        this.age = age;
        this.id = nextId;
        nextId++;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void live() {

    }


    public int getId() {
        return id;
    }


    public List<Human> getChildren() {
        return Collections.unmodifiableList(children);
        //return children;
    }

    public String getPosition(){
        return "Человек";
    }

    public void printData() {
        System.out.println(getPosition()+": " + name);
    }

    public void addChild(Human human){
        this.children.add(human);
    }

    public void removeChild(Human human){
        this.children.remove(human);
    }

    public void printSize() {
        System.out.println("Рост: " + size.height + " Вес: " + size.weight);
    }
}