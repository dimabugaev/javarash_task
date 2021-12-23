package com.javarush.task.task18.task1817;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/* 
Пробелы
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        if (args.length > 0){
            FileReader reader = new FileReader(args[0]);
            int i;
            int allcount = 0;
            int seekcount = 0;

            while ((i = reader.read()) > 0){
                allcount++;
                if ((char) i == ' ') seekcount++;
            }
            reader.close();
            try {
                System.out.println(String.format("%.2f", (double)seekcount/allcount*100));
            }catch (NumberFormatException e){

            }

        }
    }
}
