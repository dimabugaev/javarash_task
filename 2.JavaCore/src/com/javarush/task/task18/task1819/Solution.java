package com.javarush.task.task18.task1819;

import java.io.*;
import java.util.ArrayList;

/* 
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = bufferedReader.readLine();
        String fileName2 = bufferedReader.readLine();
        ArrayList<Integer> buf = new ArrayList<>();

        rewrite(new FileReader(fileName1), buf);
        FileWriter writer = new FileWriter(fileName1);
        rewrite(new FileReader(fileName2), writer, false);
        rewrite(buf, writer, true);
    }

    public static void rewrite(FileReader openreader, FileWriter openwriter, boolean endwrite) throws IOException {
        int i;
        while ((i = openreader.read()) > 0){
            openwriter.write(i);
        }
        openreader.close();

        if (endwrite) openwriter.close();
    }

    public static void rewrite(FileReader openreader, ArrayList<Integer> openwriter) throws IOException {
        int i;
        while ((i = openreader.read()) > 0){
            openwriter.add(i);
        }
        openreader.close();

    }

    public static void rewrite(ArrayList<Integer> openreader, FileWriter openwriter, boolean endwrite) throws IOException {

        for (Integer i: openreader){
            openwriter.write(i);
        }

        if (endwrite) openwriter.close();
    }
}
