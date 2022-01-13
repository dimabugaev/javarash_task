package com.javarush.task.task18.task1827;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Прайсы
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();

        if (args.length == 4 && args[0].equals("-c"))
        {
            String toWrite = getNewID(fileName) + String.format("%-30.30s", args[1]) + String.format("%-8.8s", args[2])
                    + String.format("%-4.4s", args[3]);

            FileWriter writer = new FileWriter(fileName, true);
            writer.write('\n' + toWrite);
            writer.close();
        }


    }

    public static String getNewID(String fileName) {
        int newid = 0;
        int lehgth = 50;

        char[] buf = new char[lehgth];

        try {
            FileReader reader = new FileReader(fileName);
            while (reader.read(buf,0, lehgth) != -1){
                int id = Integer.parseInt(String.valueOf(Arrays.copyOf(buf,8)).replaceAll(" ",""));
                if (newid < id) newid = id;
                if (reader.read() == -1) break; //перевед строки
            }
            reader.close();
        } catch (Exception e) {

        }
        return String.format("%-8d", newid + 1);
    }


}
