package com.javarush.task.task18.task1818;

import java.io.*;

/* 
Два в одном
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = bufferedReader.readLine();
        String fileName2 = bufferedReader.readLine();
        String fileName3 = bufferedReader.readLine();

        FileWriter writer = new FileWriter(fileName1);
        rewrite(new FileReader(fileName2), writer, false);
        rewrite(new FileReader(fileName3), writer, true);

    }

    public static void rewrite(FileReader openreader, FileWriter openwriter, boolean endwrite) throws IOException {
        int i;
        while ((i = openreader.read()) > 0){
            openwriter.write(i);
        }
        openreader.close();

        if (endwrite) openwriter.close();
    }
}
