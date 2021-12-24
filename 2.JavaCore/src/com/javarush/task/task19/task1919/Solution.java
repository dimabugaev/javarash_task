package com.javarush.task.task19.task1919;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* 
Считаем зарплаты
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        Map<String, Double> map = new TreeMap<>();

        while (reader.ready()){
            String[] data = reader.readLine().trim().split(" ");
            if (map.containsKey(data[0]))
                map.put(data[0], map.get(data[0]) + Double.parseDouble(data[1]));
            else
                map.put(data[0], Double.parseDouble(data[1]));
        }
        reader.close();

        for(Map.Entry<String, Double> res : map.entrySet()){
            System.out.println(res.getKey() + " " + res.getValue());
        }



    }
}
