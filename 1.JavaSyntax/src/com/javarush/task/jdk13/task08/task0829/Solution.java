package com.javarush.task.jdk13.task08.task0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

/* 
Нужно добавить в программу новую функциональность
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> list = new HashMap<>();
        while (true) {
            String citi = reader.readLine();
            if (citi.isEmpty()) {
                break;
            }

            String family = reader.readLine();
            if (family.isEmpty()) {
                break;
            }

            list.put(citi, family);
        }

        // Read the house number
        String citi = reader.readLine();

        if (!citi.isEmpty()) {
            String familyName = list.get(citi);
            System.out.println(familyName);
        }
    }
}
