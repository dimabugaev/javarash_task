package com.javarush.task.jdk13.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самая короткая строка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> strings = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            strings.add(reader.readLine());
        }

        int minLenght = strings.get(0).length();
        for (int i = 1; i < strings.size(); i++) {
            if (strings.get(i).length() <= minLenght){
                minLenght = strings.get(i).length();
            }
        }

        for (int i = 0; i < strings.size(); i++) {
            if (strings.get(i).length() <= minLenght) System.out.println(strings.get(i));
        }

    }
}
