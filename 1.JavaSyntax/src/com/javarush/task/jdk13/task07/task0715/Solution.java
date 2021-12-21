package com.javarush.task.jdk13.task07.task0715;

import java.util.ArrayList;

/* 
Продолжаем мыть раму
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        ArrayList<String> strings = new ArrayList<>();
        strings.add("мама");
        strings.add("мыла");
        strings.add("раму");

        for (int i = 0; i < strings.size(); i+=2) {
            strings.add(i+1,"именно");
        }

        for (String word : strings){
            System.out.println(word);
        }
    }
}
