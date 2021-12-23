package com.javarush.task.task18.task1810;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
DownloadException
*/

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String fileName = reader.readLine();
            FileInputStream openFile = new FileInputStream(fileName);
            if (openFile.available() < 1000){
                openFile.close();
                throw new DownloadException();
            }

            openFile.close();
        }


    }

    public static class DownloadException extends Exception {

    }
}
