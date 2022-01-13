package com.javarush.task.task19.task1907;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Считаем слово
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        FileReader reader = new FileReader(consoleReader.readLine());
        consoleReader.close();

        boolean pastIsLetter = false;
        char[] seekWord = new char[]{'w','o','r','l','d'};
        int count = 0;
        while (reader.ready()){
            int i = reader.read();
            if (Character.isLetter(i) && !pastIsLetter){
                if (i == seekWord[0]){
                    boolean findWord = true;
                    for (int j = 1; j < seekWord.length; j++) {
                        if (reader.ready()){
                            i = reader.read();
                            if (i != seekWord[j]) {
                                findWord = false;
                                break;
                            }
                        }else{
                            findWord = false;
                            break;
                        }
                    }
                    if (findWord){
                        if (reader.ready()) {
                            i = reader.read();
                            findWord = !Character.isLetter(i);
                        }
                        if (findWord) count++;
                    }
                }
            }
            pastIsLetter = Character.isLetter(i);
        }
        reader.close();
        System.out.println(count);

    }

}
