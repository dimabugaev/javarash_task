package com.javarush.task.jdk13.task09.task0927;

import java.util.*;

/* 
Десять котов
*/

public class Solution {

    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        //напишите тут ваш код

        Map<String, Cat> res = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            String name = "Кот номер "+ (i+1);
            res.put(name, new Cat(name));
        }

        return res;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        //напишите тут ваш код
        Set<Cat> res = new HashSet<>();
        res.addAll(map.values());
        //map.forEach((key, kat) -> res.add(kat));
        return res;
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        public String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Cat)) {
                return false;
            }
            Cat cat = (Cat) o;
            return Objects.equals(name, cat.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }
}
