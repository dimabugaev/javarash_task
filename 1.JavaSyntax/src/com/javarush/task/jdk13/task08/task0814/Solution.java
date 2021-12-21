package com.javarush.task.jdk13.task08.task0814;

import java.util.HashSet;
import java.util.Set;

/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static Set<Integer> createSet() {
        // напишите тут ваш код
        Set<Integer> set = new HashSet<>();

        while (set.size() < 20)
            set.add((int) (Math.random() *100));

        return set;
    }

    public static void removeAllNumbersGreaterThan10(Set<Integer> set) {
        // напишите тут ваш код
        set.removeIf(i -> i > 10);
    }

    public static void main(String[] args) {

    }
}
