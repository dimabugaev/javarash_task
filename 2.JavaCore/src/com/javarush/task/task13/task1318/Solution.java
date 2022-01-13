package com.javarush.task.task13.task1318;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = null;
        FileInputStream freader = null;

        try{
            reader = new BufferedReader(new InputStreamReader(System.in));
            freader = new FileInputStream(reader.readLine());

            Scanner scanfile = new Scanner(freader);

            while (scanfile.hasNext())
                System.out.println(scanfile.nextLine());

        }catch (Exception e){
            System.out.println(e);
        }finally {
            if (reader != null)
                reader.close();
            if (freader != null)
                freader.close();
        }
    }
}