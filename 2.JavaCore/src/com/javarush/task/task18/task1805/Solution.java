package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        FileInputStream fileInputStream = new FileInputStream(fileName);

        ArrayList<Integer> list = new ArrayList<>();

        while (fileInputStream.available() > 0)
        {
            int data = fileInputStream.read();
            if (!list.contains(data)) list.add(data);
        }
        Collections.sort(list);
        fileInputStream.close();

        for(Integer value: list)
            System.out.print(value + " ");

    }
}
