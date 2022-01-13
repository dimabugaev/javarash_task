package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static{
        labels.put(23.4, "smirnoff");
        labels.put(30.7, "putinka");
        labels.put(12.4, "shardone");
        labels.put(10.2, "porter");
        labels.put(45.5, "zubrovka");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
