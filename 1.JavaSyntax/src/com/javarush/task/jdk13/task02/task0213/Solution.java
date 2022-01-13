package com.javarush.task.jdk13.task02.task0213;

/* 
У каждого животного должна быть хозяйка
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Woman woman = new Woman();
        Cat cat = new Cat();
        Dog dog = new Dog();
        Fish fish = new Fish();

        cat.owner = dog.owner = fish.owner = woman;
    }

    public static class Cat {
        public Woman owner;
    }

    public static class Dog {
        public Woman owner;
    }

    public static class Fish {
        public Woman owner;
    }

    public static class Woman {
    }
}
