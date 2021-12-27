package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/

public class Solution {

    public static Map<String, String> runtimeStorage = new HashMap<>();

    public static void save(OutputStream outputStream) throws Exception {
        //напишите тут ваш код
        Properties properties = new Properties();
        properties.putAll(runtimeStorage);
        properties.store(outputStream, "good");
    }

    public static void load(InputStream inputStream) throws IOException {
        //напишите тут ваш код
        runtimeStorage.clear();
        Properties properties = new Properties();
        properties.load(inputStream);

        for(Map.Entry<Object, Object> unit: properties.entrySet())
        {
            runtimeStorage.put((String) unit.getKey(), (String) unit.getValue());
        }
        //properties.
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fos = new FileInputStream(reader.readLine())) {
            load(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(runtimeStorage);
    }
}
