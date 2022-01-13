package com.javarush.task.task13.task1319;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileWriter;
import java.io.InputStreamReader;



/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = null;
        BufferedWriter writer = null;

        try {
            reader = new BufferedReader(new InputStreamReader(System.in));

            writer = new BufferedWriter(new FileWriter(reader.readLine()));
            while (true){
                String line = reader.readLine();
                writer.write(line);
                writer.newLine();
                if (line.equals("exit")) break;
            }

        }catch (Exception e){
            System.out.println(e);
        }finally {
            if (reader != null)
                reader.close();
            if (writer != null)
                writer.close();
        }

    }
}
