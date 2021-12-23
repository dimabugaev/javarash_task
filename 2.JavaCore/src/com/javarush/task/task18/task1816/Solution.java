package com.javarush.task.task18.task1816;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 
Английские буквы
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        if (args.length > 0) {
            String dataLine = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm";
            FileReader reader = new FileReader(args[0]);
            int i;
            int sum = 0;
            while ((i = reader.read()) != -1){
                if ( 65 <=i && i <= 122) sum++;
                //if (dataLine.indexOf(i) > 0) sum++;
            }
            reader.close();
            System.out.println(sum);
        }
    }
}
