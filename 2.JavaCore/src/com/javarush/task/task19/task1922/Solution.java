package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {

        try(
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file = new BufferedReader(new FileReader(console.readLine()));) {
            while (file.ready()){
                String line = file.readLine();
                if (getCountWords(line) == 2)
                    System.out.println(line);
            }
        }


    }

    public static int getCountWords(String line){
        Map<String, Integer> map = new HashMap<>();
        String[] incomeWords = line.trim().split(" ");

        for (String word : Solution.words)
            map.put(word, 0);

        for (int i = 0; i < incomeWords.length; i++) {
            if (map.containsKey(incomeWords[i].trim())){
                map.put(incomeWords[i].trim(), map.get(incomeWords[i].trim()) + 1);
            }
        }

        int sum = 0;
        for (Integer value : map.values())
            sum += value;

        return sum;
    }
}
