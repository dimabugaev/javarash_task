package com.javarush.task.jdk13.task05.task0509;

/* 
Заполнить класс Friend
*/

public class Friend {
    //напишите тут ваш код
    public String name;
    public int age;
    public char sex;

    public void initialize(String name){
        this.name = name;
    }
    public void initialize(String name, int age){
        this.name = name;
        this.age = age;
    }
    public void initialize(String name, int age, char sex){
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public static void main(String[] args) {

    }
}
