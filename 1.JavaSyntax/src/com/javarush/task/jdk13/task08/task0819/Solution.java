package com.javarush.task.jdk13.task08.task0819;

import java.util.HashSet;
import java.util.Set;

/* 
Set из котов
*/

public class Solution {

    public static void main(String[] args) {
        Set<Cat> cats = createCats();

        //напишите тут ваш код. step 3 - пункт 3
        Object[] arcat = cats.toArray();
        cats.remove(arcat[0]);

        printCats(cats);
    }

    public static Set<Cat> createCats() {
        //напишите тут ваш код. step 2 - пункт 2
        Set<Cat> cats = new HashSet<>();

        for (int i = 0; i < 3; i++) {
            cats.add(new Cat(Integer.toString(i)));
        }
        return cats;
    }

    public static void printCats(Set<Cat> cats) {
        // step 4 - пункт 4
        for (Cat cat:cats){
            System.out.println(cat);
        }
    }

    // step 1 - пункт 1
    public static class Cat{

        public String name;
        public Cat(){

        }
        public Cat(String name){
            this.name = name;
        }

//        public String toString() {
//            return "Cat{" +
//                    "name='" + name + '\'' +
//                    '}';
//        }
    }
}
