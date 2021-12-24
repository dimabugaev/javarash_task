package com.javarush.task.task19.task1925;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Длинные слова
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        if (args.length > 1) {

            try(Scanner fileReader = new Scanner(new FileReader(args[0]));
            FileWriter fileWriter = new FileWriter(args[1]);){
                boolean first = true;
                while (fileReader.hasNext()){

                    String word = fileReader.next();
                    if (word.length() > 6){
                        if (!first) fileWriter.write(',');

                        fileWriter.write(word);
                        first = false;
                    }
                }
            }
        }
    }
}
