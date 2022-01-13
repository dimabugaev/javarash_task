package com.javarush.task.jdk13.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Сортировка списка
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();




        for (int i = 0; i < 10; i++) {
            list.add(reader.readLine());
        }

        int tekSize = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() < tekSize){
                System.out.println(i);
                break;
            }
            else {
                tekSize = list.get(i).length();
            }
        }

    }
}

