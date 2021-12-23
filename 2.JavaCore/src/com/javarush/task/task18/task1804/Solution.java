package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        FileInputStream fileInputStream = new FileInputStream(fileName);

        HashMap<Integer, Integer> count = new HashMap<>();

        while (fileInputStream.available() > 0)
        {
            int data = fileInputStream.read();
            Integer keycount = count.get(data);
            if (keycount == null) keycount = 0;
            count.put(data, keycount+1);
        }
        fileInputStream.close();
        int min = Collections.min(count.values());

        for(Map.Entry<Integer, Integer> item: count.entrySet()){
            if (item.getValue() == min)
                System.out.print(item.getKey() + " ");
        }
    }
}
