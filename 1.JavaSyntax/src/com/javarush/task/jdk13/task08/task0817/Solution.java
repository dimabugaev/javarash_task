package com.javarush.task.jdk13.task08.task0817;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Удалить людей, имеющих одинаковые имена
*/

public class Solution {
    public static Map<String, String> createMap() {
        //напишите тут ваш код
        Map<String, String> map = new HashMap<>();

        map.put("Иванов", "Павел");
        map.put("Петров", "Михаил");
        map.put("Павлов", "Михаил");
        map.put("Федотов", "Андрей");
        map.put("Кощеев", "Петр");
        map.put("Сидоров", "Андрей");
        map.put("Емельянов", "Дмитрий");
        map.put("Аксельрод", "Георгий");
        map.put("Конюхов", "Илья");
        map.put("Шекспир", "Вильям");

        return map;
    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        //напишите тут ваш код
        Map<String,Integer> count = new HashMap<>();

        for (String firstName : map.values()) {
            count.put(firstName, count.getOrDefault(firstName, 0) + 1);
        }

        for (Map.Entry<String, Integer> toRemove : count.entrySet()){
            if (toRemove.getValue() > 1) removeItemFromMapByValue(map, toRemove.getKey());
        }
    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {
        removeTheFirstNameDuplicates(createMap());

    }
}
