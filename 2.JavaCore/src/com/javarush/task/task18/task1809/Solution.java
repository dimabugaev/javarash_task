package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* 
Реверс файла
*/

public class Solution {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();

        FileInputStream fileInputStream = new FileInputStream(fileName1);
        FileOutputStream fileOutputStream = new FileOutputStream(fileName2);

        if (fileInputStream.available() > 0){
            byte[] buf = new byte[fileInputStream.available()];
            int count = fileInputStream.read(buf);
            if (count > 0){
                List<Byte> datafile = new ArrayList<>();
                for (int i = 0; i < count; i++) {
                    datafile.add(buf[i]);
                }
                Collections.reverse(datafile);
                for (Byte simbol: datafile)
                    fileOutputStream.write((byte) simbol);

            }
        }

        fileInputStream.close();
        fileOutputStream.close();
    }
}
