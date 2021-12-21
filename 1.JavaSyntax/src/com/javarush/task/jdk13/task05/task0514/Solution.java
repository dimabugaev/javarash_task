package com.javarush.task.jdk13.task05.task0514;

/* 
Инициализация объектов
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код

        Person person = new Person();
        person.initialize("Vasya", 31);
    }

    static class Person {

        String name;
        int age;

        public void initialize(String name, int age){
            this.name = name;
            this.age = age;
        }
        //напишите тут ваш код
    }
}
