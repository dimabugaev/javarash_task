package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader cons = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, String> dataFile = new TreeMap<>();
        String fileName = null;

        while (true){
            String line = cons.readLine();
            if (line.equals("end")) break;

            int lastPointIndex = line.lastIndexOf(".");
            if (lastPointIndex > 0){
                int lastIndex = line.length();
                dataFile.put(Integer.parseInt(line.substring(lastPointIndex +5, lastIndex)), line);
                fileName = line.substring(0, lastPointIndex);
            }
        }
        cons.close();

        if (fileName != null){
            BufferedWriter writeFile = new BufferedWriter(new FileWriter(fileName));

            for(Map.Entry<Integer, String> pair : dataFile.entrySet()){
                BufferedReader reader = new BufferedReader(new FileReader(pair.getValue()));
                int i;
                while((i = reader.read()) > 0) {
                    writeFile.write(i);
//                    String line = reader.readLine();
//                    if (line != null)
//                        writeFile.write(line);
//                    else{
//                        reader.close();
//                        break;
                    //reader.read()

                    //}
                }
                reader.close();
            }
            writeFile.close();
        }
    }
}
