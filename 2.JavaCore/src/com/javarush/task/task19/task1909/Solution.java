package com.javarush.task.task19.task1909;

import java.io.*;
import java.util.ArrayList;

/* 
Замена знаков
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        String inputFileName;
        String outputFileName;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            inputFileName = reader.readLine();
            outputFileName = reader.readLine();
        }

        ArrayList<Integer> fileContent = new ArrayList<>();
        try (BufferedReader inputFileReader = new BufferedReader(new FileReader(inputFileName))) {
            while (inputFileReader.ready()) {
                int i;
                if ((i = inputFileReader.read()) != '.')
                    fileContent.add(i);
                else
                    fileContent.add((int)'!');
            }
        }

        try (BufferedWriter outputFileWriter = new BufferedWriter(new FileWriter(outputFileName))) {
            for (Integer line : fileContent) {
                try {
                    outputFileWriter.write(line);
                } catch (Exception ignore) {
                    /* NOP */
                }
            }
        }
    }
}
