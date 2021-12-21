package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            String line = reader.readLine();
            if (line.equals("exit")) break;

            int select = 0;

            if (line.indexOf('.') > 0){
                try {
                    Double.parseDouble(line);
                    select = 1;
                }catch (NumberFormatException e)
                {
                    select = 0;
                }
            }

            if (select != 1){
                int testValue = -1;
                try {
                    testValue = Integer.parseInt(line);
                    select = 2;
                }catch (NumberFormatException e)
                {
                    select = 0;
                }finally {
                    if (select == 2){
                        if (testValue <= 0 || testValue >= 128) {
                            select = 3;
                        }
                    }
                }
            }

            switch (select){
                case 0:{
                    print(line);
                    break;
                }
                case 1:{
                    print(Double.parseDouble(line));
                    break;
                }
                case 2:{
                    print(Short.parseShort(line));
                    break;
                }
                case 3:{
                    print(Integer.parseInt(line));
                    break;
                }
            }
        }

        reader.close();

    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
