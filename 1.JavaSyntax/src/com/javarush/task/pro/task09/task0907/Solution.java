package com.javarush.task.pro.task09.task0907;

import java.util.regex.Pattern;

/* 
Шестнадцатеричный конвертер
*/

public class Solution {
    private static final String HEX = "0123456789abcdef";

    public static void main(String[] args) {
        int decimalNumber = 1256;
        System.out.println("Десятичное число " + decimalNumber + " равно шестнадцатеричному числу " + toHex(decimalNumber));
        String hexNumber = "4e8";
        System.out.println("Шестнадцатеричное число " + hexNumber + " равно десятичному числу " + toDecimal(hexNumber));
    }

    public static String toHex(int decimalNumber) {
        //напишите тут ваш код
        String res = "";
        String dataHEX = "0123456789abcdef";
        while (decimalNumber > 0){
            res = dataHEX.charAt(decimalNumber % 16) + res;
            decimalNumber /= 16;
        }
        return res;
    }

    public static int toDecimal(String hexNumber) {
        //напишите тут ваш код
        int res = 0;

        if (hexNumber != null) {
            String dataHEX = "0123456789abcdef";
            for (int i = 0; i < hexNumber.length(); i++) {
                res = 16 * res + dataHEX.indexOf(hexNumber.charAt(i));
            }
        }

        return res;
    }
}
