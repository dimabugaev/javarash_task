package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

/* 
Использование TreeSet
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length > 0){
            TreeSet<Character> set = new TreeSet<>();

            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            while (reader.ready()){
                char ch = (char) reader.read();
                if (ch >= 65 && ch <= 90)
                    ch += 32;

                if (ch >= 97 && ch <= 122){
                    set.add(ch);
                }
            }
            int i = 0;
            for (Character ch : set){
                if (i == 5) break;
                System.out.print(ch);
                i++;
            }
        }
    }
}
