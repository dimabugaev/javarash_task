package com.javarush.task.task19.task1906;

import java.io.*;
import java.util.ArrayList;

/* 
Четные символы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader consolReader = new BufferedReader(new InputStreamReader(System.in));

        FileReader reader = new FileReader(consolReader.readLine());
        FileWriter writer = new FileWriter(consolReader.readLine());
        consolReader.close();
        int count = 0;
        while (reader.ready()){
            int i = reader.read();
            count++;
            if (count % 2 == 0)
                writer.write(i);
        }
        reader.close();
        writer.close();

    }
}
