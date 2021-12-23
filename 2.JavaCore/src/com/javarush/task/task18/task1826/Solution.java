package com.javarush.task.task18.task1826;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
Шифровка
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        if (args.length == 3)
        {
            FileInputStream inputStream = new FileInputStream(args[1]);
            FileOutputStream outputStream = new FileOutputStream(args[2]);

            switch (args[0]){
                case "-e":{
                    encrypt(inputStream, outputStream);
                    break;
                }
                case "-d":{
                    decrypt(inputStream, outputStream);
                    break;
                }

            }

            inputStream.close();
            outputStream.close();
        }
    }

    public static void encrypt(FileInputStream in, FileOutputStream out) throws IOException {
        int i;
        while ((i = in.read()) != -1){
            out.write(i + 5);
        }
    }

    public static void decrypt(FileInputStream in, FileOutputStream out) throws IOException {
        int i;
        while ((i = in.read()) != -1){
            out.write(i - 5);
        }
    }

}
