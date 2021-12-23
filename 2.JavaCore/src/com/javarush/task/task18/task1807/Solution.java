package com.javarush.task.task18.task1807;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Подсчет запятых
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        FileInputStream fileInputStream = new FileInputStream(fileName);

        int countdata = 0;
        while (fileInputStream.available() > 0)
        {
            int data = fileInputStream.read();
            if ((byte)data == ',') countdata++;
        }
        fileInputStream.close();
        System.out.println(countdata);
    }
}
