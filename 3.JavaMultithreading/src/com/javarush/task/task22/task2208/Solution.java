package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
*/

public class Solution {
    public static void main(String[] args) {

        Map<String, String> test = new HashMap<>();
        test.put("name", "Ivanov");
        test.put("country", "Ukraine");
        test.put("city", "Kiev");
        test.put("age", "null");
        test.put("page", null);

        System.out.println(getQuery(test));
    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder res = new StringBuilder();
        for(Map.Entry<String, String> item : params.entrySet())
        {
            if ("null".equals(item.getValue()) || item.getValue() == null) continue;

            if (res.length() > 0)
                res.append(" and ");

            res.append(item.getKey()).append(" = ").append("'" + item.getValue() + "'");
        }
        return res.toString();
    }
}
