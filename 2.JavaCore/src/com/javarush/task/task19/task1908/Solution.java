package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader(consoleReader.readLine()));
        BufferedWriter writer = new BufferedWriter(new FileWriter(consoleReader.readLine()));
        consoleReader.close();

        boolean writeNum = true;
        ArrayList<Integer> num = new ArrayList<>();

        while (reader.ready()) {
            int i = reader.read();
            if (Character.isDigit(i) && writeNum)
                num.add(i);
            else {
                if (i == ' ') {
                    write(writer, num);

                    writeNum = true;
                } else {
                    writeNum = false;
                    if (num.size() > 0) num.clear();
                }
            }
        }
        write(writer, num);

        writer.close();
        reader.close();

    }

    public static void write(BufferedWriter writer, List<Integer> num) throws IOException {
        if (num.size() > 0){
            num.forEach(j -> {
                try {
                    writer.write(j);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            writer.write(' ');
            num.clear();
        }
    }
}
