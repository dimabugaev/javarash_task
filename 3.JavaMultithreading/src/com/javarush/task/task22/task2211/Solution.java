package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* 
Смена кодировки
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length > 1){
            Charset income = Charset.forName("Windows-1251");
            Charset outcome = StandardCharsets.UTF_8;


            try (FileInputStream fileInputStream = new FileInputStream(args[0]);
                FileOutputStream fileOutputStream = new FileOutputStream(args[1]);){
                byte[] buf = new byte[fileInputStream.available()];

                while (fileInputStream.available() > 0){
                    int count = fileInputStream.read(buf);
                    String stbuf = new String(buf, income);
                    buf = stbuf.getBytes(outcome);
                    fileOutputStream.write(buf);

                }
            }
        }
    }
}
