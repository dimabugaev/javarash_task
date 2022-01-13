package com.javarush.task.jdk13.task08.task0802;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Map из 10 пар
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Map<String, String> map = new HashMap<>();
        map.put("арбуз", "ягода");
        map.put("банан", "трава");
        map.put("вишня", "ягода");
        map.put("груша", "фрукт");
        map.put("дыня", "овощ");
        map.put("ежевика", "куст");
        map.put("жень-шень", "корень");
        map.put("земляника", "ягода");
        map.put("ирис", "цветок");
        map.put("картофель", "клубень");

        Iterator<Map.Entry<String, String>> data = map.entrySet().iterator();

        while (data.hasNext()){

            Map.Entry<String, String> rec = data.next();

            System.out.println(rec.getKey()+" - "+rec.getValue());
        }


    }
}
