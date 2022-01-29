package com.javarush.task.task32.task3210;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {
        if (args.length > 2){
            try(RandomAccessFile randomAccessFile = new RandomAccessFile(args[0], "rw");) {
                long number = Long.parseLong(args[1]);
                int lengthText = args[2].length();
                long lengthFile = randomAccessFile.length();
                boolean result = true;

                if (number + lengthText > lengthFile)
                    result = false;

                if (result){
                    byte[] buffer = new byte[lengthText];
                    randomAccessFile.seek(number);
                    randomAccessFile.read(buffer, 0, lengthText);
                    if (!args[2].equals(new String(buffer)))
                        result = false;

//                    if (readLength != lengthText)
//                        result = false;
//
//                    if (result){
//
//                        if (!buffer.toString().equals(args[2]))
//                            result = false;
//                    }
                }

                randomAccessFile.seek(lengthFile);
                String resultString = "true";
                if (!result)
                    resultString = "false";

                randomAccessFile.write(resultString.getBytes(StandardCharsets.UTF_8));


            }
        }
    }
}
