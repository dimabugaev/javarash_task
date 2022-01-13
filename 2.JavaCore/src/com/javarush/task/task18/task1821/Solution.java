package com.javarush.task.task18.task1821;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/* 
Встречаемость символов
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        if (args.length > 0) {
            Map<Integer, Integer> stat = new TreeMap<>();
            FileReader reader = new FileReader(args[0]);
            int i;
            while ((i = reader.read()) > 0){
                if (stat.containsKey(i)) stat.put(i, stat.get(i) + 1);
                else stat.put(i, 1);
            }
            reader.close();
            for(Map.Entry<Integer, Integer> pair: stat.entrySet()){
                //System.out.println((char)(pair.getKey() + '0') + " " + pair.getValue());
                int buf = pair.getKey();
                System.out.println((char) buf + " " + pair.getValue());
            }
        }
    }
}
