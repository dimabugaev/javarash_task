package com.javarush.task.jdk13.task08.task0818;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Налоговая и зарплаты
*/

public class Solution {
    public static Map<String, Integer> createMap() {
        //напишите тут ваш код
        Map<String, Integer> map = new HashMap<>();

        map.put("Иванов", 200);
        map.put("Петров", 300);
        map.put("Павлов", 600);
        map.put("Федотов", 500);
        map.put("Кощеев", 1000);
        map.put("Сидоров", 2000);
        map.put("Емельянов", 150);
        map.put("Аксельрод", 4000);
        map.put("Конюхов", 333);
        map.put("Шекспир", 5060);

        return map;
    }

    public static void removeItemFromMap(Map<String, Integer> map) {
        //напишите тут ваш код

        //напишите тут ваш код
        ArrayList<String> keyToRemove = new ArrayList<>();

        for (Map.Entry<String, Integer> data : map.entrySet()){
            if (data.getValue() < 500)
                keyToRemove.add(data.getKey());
        }

        for(String key : keyToRemove){
            map.remove(key);
        }
    }

    public static void main(String[] args) {
        //Collections.
        TestEnum.SEVER.ordinal();
    }
}