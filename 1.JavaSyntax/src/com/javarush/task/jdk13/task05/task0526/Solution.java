package com.javarush.task.jdk13.task05.task0526;

/* 
Мужчина и женщина
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код

        Man man1 = new Man("Nikolay", 25, "Moskva");
        Man man2 = new Man("Anatoliy", 53, "Omsk");
        System.out.println(man1);
        System.out.println(man2);

        Woman woman1 = new Woman("Lidiya", 18, "Suzdal");
        Woman woman2 = new Woman("Klava", 24, "Eburg");
        System.out.println(woman1);
        System.out.println(woman2);
    }

    public static class Man {

        String name;
        int age;
        String address;

        public Man(String name, int age, String address){
            this.address = address;
            this.age = age;
            this.name = name;
        }

        public String toString(){
            return name + " " + age + " " + address;
        }

    }

    public static class Woman {

        String name;
        int age;
        String address;

        public Woman(String name, int age, String address){
            this.address = address;
            this.age = age;
            this.name = name;
        }

        public String toString(){
            return name + " " + age + " " + address;
        }

    }

    //напишите тут ваш код
}
