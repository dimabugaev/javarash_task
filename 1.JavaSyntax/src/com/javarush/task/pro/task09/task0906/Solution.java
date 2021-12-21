package com.javarush.task.pro.task09.task0906;

import java.util.regex.Pattern;

/* 
Двоичный конвертер
*/

public class Solution {
    public static void main(String[] args) {
        int decimalNumber = Integer.MAX_VALUE;
        System.out.println("Десятичное число " + decimalNumber + " равно двоичному числу " + toBinary(decimalNumber));
        String binaryNumber= "1111111111111111111111111111110";
        System.out.println("Двоичное число " + binaryNumber + " равно десятичному числу " + toDecimal(binaryNumber));
    }

    public static String toBinary(int decimalNumber) {
        //напишите тут ваш код
        String res = "";

        while (decimalNumber > 0){
            res = decimalNumber % 2 + res;
            decimalNumber = decimalNumber/2;
        }

        return res;
    }

    public static int toDecimal(String binaryNumber) {
        //напишите тут ваш код
        int res = 0;

        if (binaryNumber != null){
            for (int i = 0; i < binaryNumber.length(); i++) {
                res += (binaryNumber.charAt(binaryNumber.length() - i - 1) - 48) * Math.pow(2, i);
            }
        }
        return res;
    }
}
