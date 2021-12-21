package com.javarush.task.jdk13.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Максимальное и минимальное числа в массиве
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int maximum;
        int minimum;

        int[] data = new int[20];

        for (int i = 0; i < data.length; i++) {
            data[i] = Integer.parseInt(reader.readLine());
        }

        maximum = minimum = data[0];
        for (int i = 1; i < data.length; i++) {
            if (data[i] > maximum) maximum = data[i];
            if (data[i] < minimum) minimum = data[i];
        }
        //напишите тут ваш код

        System.out.print(maximum + " " + minimum);
    }
}
