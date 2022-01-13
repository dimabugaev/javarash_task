package com.javarush.task.task18.task1822;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Поиск данных внутри файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length > 0) {
            BufferedReader cons = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader file = new BufferedReader(new FileReader(cons.readLine()));
            cons.close();
            String linefile;
            while ((linefile = file.readLine()) != null){
                String[] detail = linefile.split(" ");
                if (detail.length > 0){
                    if (detail[0].equals(args[0]))
                        System.out.println(linefile);
                }
            }
            file.close();
        }

    }
}
