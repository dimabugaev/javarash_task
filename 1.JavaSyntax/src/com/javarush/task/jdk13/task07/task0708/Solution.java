package com.javarush.task.jdk13.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Самое большое число
*/

public class Solution {

    private static ArrayList<Integer> integers = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            integers.add(Integer.parseInt(reader.readLine()));
        }
        Collections.sort(integers);
        System.out.println(integers.get(integers.size()-1));

    }
}
