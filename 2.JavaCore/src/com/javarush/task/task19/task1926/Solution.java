package com.javarush.task.task19.task1926;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/* 
Перевертыши
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //Collections.reverse();
        try(BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(consoleReader.readLine()));){
            while (fileReader.ready()){
                System.out.println(new StringBuilder(fileReader.readLine()).reverse());
            }
        }
    }
}
