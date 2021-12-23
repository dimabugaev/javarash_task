package com.javarush.task.task18.task1820;

import java.io.*;
import java.util.Scanner;

/* 
Округление чисел
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = bufferedReader.readLine();
        String fileName2 = bufferedReader.readLine();

        FileInputStream fileInputStream = new FileInputStream(fileName1);
        Scanner scanner = new Scanner(fileInputStream);

        FileWriter writer = new FileWriter(fileName2);
        while (scanner.hasNextDouble()){
            writer.write(String.valueOf(Math.round(scanner.nextDouble())));
            writer.write(" ");
        }
        writer.close();
        scanner.close();
        fileInputStream.close();

    }
}
