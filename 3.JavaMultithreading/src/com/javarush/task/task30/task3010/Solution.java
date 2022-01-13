package com.javarush.task.task30.task3010;

import java.util.regex.Pattern;

/* 
Минимальное допустимое основание системы счисления
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        try {
            if (args.length > 0){
                String controlLine = "[0-9a-zA-Z]+";

                String system = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                //String system = "0123456789abcdefghijklmnopqrstuvwxyz";

                if (args[0].matches(controlLine)){
                    int min = 2;
                    for (int i = 0; i < args[0].length(); i++) {
                        int ch = args[0].charAt(i);
                        if (ch > 96)
                            ch = ch - 32;
                        int ind = system.indexOf(ch) + 1;
                        if (ind > min)
                            min = ind;
                    }
                    System.out.println(min);
                }else
                    System.out.println("incorrect");


            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }
}