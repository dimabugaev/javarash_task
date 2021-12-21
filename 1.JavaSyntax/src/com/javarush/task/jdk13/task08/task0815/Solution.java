package com.javarush.task.jdk13.task08.task0815;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Одинаковые имя и фамилия
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

    public static int getCountTheSameFirstName(Map<String, String> map, String name) {
        //напишите тут ваш код
        int res = 0;
        Iterator<String> iterator = map.values().iterator();
        while (iterator.hasNext()){
            if (iterator.next().equals(name))
                res +=1;
        }

        return res;
    }

    public static int getCountTheSameLastName(Map<String, String> map, String lastName) {
        //напишите тут ваш код
        int res = 0;
        if (map.get(lastName) != null) res = 1;

        return res;
    }

    public static void main(String[] args) {

    }
}
