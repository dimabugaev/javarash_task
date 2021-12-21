package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        //напишите тут ваш код
        reader.close();

        int start = url.indexOf("?");
        StringTokenizer tok = new StringTokenizer(url.substring(start + 1, url.length()),"&");

        String valueObj = null;
        while (tok.hasMoreTokens())
        {
            String param = tok.nextToken();
            int end = param.length();
            if (param.indexOf("=") > 0){
                end = param.indexOf("=");
            }

            String nameParam = param.substring(0, end);
            System.out.print(nameParam + " ");

            if (nameParam.equals("obj")) valueObj = param.substring(end + 1);
        }

        if (valueObj != null){
            System.out.println();
            try{
                double val = Double.parseDouble(valueObj);
                alert(val);
            }catch (Exception e){
                alert(valueObj);
            }
        }


    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
