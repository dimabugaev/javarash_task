package com.javarush.task.jdk13.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Удалить всех людей, родившихся летом
*/

public class Solution {
    public static Map<String, Date> createMap() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MMMM d yyyy", Locale.ENGLISH);
        Map<String, Date> map = new HashMap<>();
        map.put("Сталлоне", dateFormat.parse("MAY 1 2012"));
        map.put("Сильвестр", dateFormat.parse("JULY 1 2012"));
        map.put("Шварц", dateFormat.parse("AUGUST 1 2012"));
        map.put("Арнольд", dateFormat.parse("MAY 1 2012"));
        map.put("Брюс", dateFormat.parse("MAY 1 2012"));
        map.put("Джеки", dateFormat.parse("AUGUST 1 2012"));
        map.put("Супермэн", dateFormat.parse("MAY 1 2012"));
        map.put("Кевин", dateFormat.parse("MAY 1 2012"));
        map.put("Костнер", dateFormat.parse("JUNE 1 2012"));
        map.put("Чан", dateFormat.parse("MAY 1 2012"));

        if (map.isEmpty()) throw new ParseException("is empty",5);

        return map;
        //напишите тут ваш код
    }

    public static void removeAllSummerPeople(Map<String, Date> map) {
        //напишите тут ваш код
        ArrayList<String> keyToRemove = new ArrayList<>();

        DateFormat simpleDateFormat = new SimpleDateFormat("MM");

        for (Map.Entry<String, Date> data : map.entrySet()){
            int mount = Integer.parseInt(simpleDateFormat.format(data.getValue()));
            if (mount > 5 && mount < 9)
                keyToRemove.add(data.getKey());
        }

        for(String key : keyToRemove){
            map.remove(key);
        }
    }

    public static void main(String[] args) {
        try {
            removeAllSummerPeople(createMap());
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
