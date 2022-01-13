package com.javarush.task.task19.task1923;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/* 
Слова с цифрами
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length > 1){

            try (Scanner reader = new Scanner(new FileReader(args[0]));
            FileWriter writer = new FileWriter(args[1]);){
                while (reader.hasNext()){
                    String word = reader.next();
                    if (checkDigit(word))
                        writer.write(word + " ");
                }
            }
        }
    }

    public static boolean checkDigit(String word)
    {
        return !"".equals(word.replaceAll("\\D", ""));
    }
}
