package com.javarush.task.task32.task3201;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

/* 
Запись в существующий файл
*/

public class Solution {
    public static void main(String... args) throws IOException {
        if (args.length > 2){
            try(RandomAccessFile randomAccessFile = new RandomAccessFile(args[0], "rw");) {
                randomAccessFile.seek(Math.min(randomAccessFile.length(), Long.parseLong(args[1])));

                randomAccessFile.write(args[2].getBytes(StandardCharsets.UTF_8));
                //randomAccessFile.writeBytes(args[2]);
            }
        }
    }
}
