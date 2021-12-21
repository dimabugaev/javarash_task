package com.javarush.task.jdk13.task05.task0501;

/* 
Кошачья бойня(1)
*/

import java.util.Random;

public class Solution {

    public static class Cat {
        private String name;
        private int age;
        private int weight;
        private int strength;
        //напишите тут ваш код

        public Cat(String name, int age, int weight, int strength){
            this.age = age;
            this.strength = strength;
            this.name = name;
            this.weight = weight;
        }

        public boolean fight(Cat anotherCat){

            int thiswin = 0;

            if (this.weight > anotherCat.weight) thiswin +=1;
            if (this.weight < anotherCat.weight) thiswin -=1;

            if (this.strength > anotherCat.strength) thiswin +=1;
            if (this.strength < anotherCat.strength) thiswin -=1;

            if (this.age > anotherCat.age) thiswin +=1;
            if (this.age < anotherCat.age) thiswin -=1;

            return thiswin > 0;
        }
    }

    public static void main(String[] args) {

        Cat kuza = new Cat("Кузя", 2, 5, 10);
        Cat vasya = new Cat("Вася", 6, 4, 8);
        Cat slon = new Cat("Слон", 1, 10, 15);

        if (kuza.fight(vasya)) System.out.printf("В бою %1$s - %2$s, победил %1$s\n", kuza.name, vasya.name);
        else System.out.printf("В бою %1$s - %2$s, победил %2$s", kuza.name, vasya.name);

        if (slon.fight(kuza)) System.out.printf("В бою %1$s - %2$s, победил %1$s\n", slon.name, kuza.name);
        else System.out.printf("В бою %1$s - %2$s, победил %2$s", slon.name, kuza.name);

        if (vasya.fight(slon)) System.out.printf("В бою %1$s - %2$s, победил %1$s\n", vasya.name, slon.name);
        else System.out.printf("В бою %1$s - %2$s, победил %2$s", vasya.name, slon.name);




    }
}
