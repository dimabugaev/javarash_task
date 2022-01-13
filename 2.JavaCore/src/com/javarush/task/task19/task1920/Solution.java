package com.javarush.task.task19.task1920;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/* 
Самый богатый
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        Map<String, Double> map = new TreeMap<>();
        Double maxsum = 0d;
        while (reader.ready()){
            String[] data = reader.readLine().trim().split(" ");
            if (map.containsKey(data[0])) {
                map.put(data[0], map.get(data[0]) + Double.parseDouble(data[1]));
                if (maxsum.compareTo(map.get(data[0])) < 0)
                    maxsum = map.get(data[0]);
            }
            else{
                map.put(data[0], Double.parseDouble(data[1]));
                if (maxsum.compareTo(Double.parseDouble(data[1])) < 0)
                    maxsum = Double.parseDouble(data[1]);
            }

        }
        reader.close();


        for(Map.Entry<String, Double> res : map.entrySet()){
            if (maxsum.equals(res.getValue()))
                System.out.print(res.getKey()+ " ");
            //System.out.println(res.getKey() + " " + res.getValue());
        }
    }
}
