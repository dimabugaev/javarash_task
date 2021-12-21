package com.javarush.task.jdk13.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Минимальное или максимальное
*/

public class Solution {

    public static ArrayList<String> strings;

    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        strings = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            strings.add(reader.readLine());
        }

        int max = strings.get(0).length();
        int min = max;
        int positionMin = 0;
        int positionMax = 0;
        for (int i = 1; i < strings.size(); i++) {
            if (strings.get(i).length() < min){
                min = strings.get(i).length();
                positionMin = i;
            }else if (strings.get(i).length() > max){
                max = strings.get(i).length();
                positionMax = i;
            }
        }

        if (positionMax >= positionMin){
            System.out.printf(strings.get(positionMin));
        }else{
            System.out.printf(strings.get(positionMax));
        }
    }
}
