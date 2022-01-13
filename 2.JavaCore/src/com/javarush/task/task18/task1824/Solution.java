package com.javarush.task.task18.task1824;

import java.io.*;
import java.util.ArrayList;

/* 
Файлы и исключения
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        //ArrayList<FileReader> readers = new ArrayList<>();
        BufferedReader cons = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            FileReader reader = null;
            String fileName = cons.readLine();
            try {
                reader = new FileReader(fileName);
                reader.close();
            }catch (FileNotFoundException e){
                System.out.println(fileName);
                break;
            }
        }
    }
}
