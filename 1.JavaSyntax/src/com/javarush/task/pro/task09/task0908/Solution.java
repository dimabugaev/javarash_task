package com.javarush.task.pro.task09.task0908;

import java.util.Arrays;
import java.util.regex.Pattern;

/* 
Двоично-шестнадцатеричный конвертер
*/

public class Solution {

    public static String[] dataBIN = {"0000","0001","0010","0011","0100","0101","0110","0111",
            "1000","1001","1010","1011","1100","1101","1110","1111"};
    public static String dataHEX = "0123456789abcdef";

    public static void main(String[] args) {
        String binaryNumber = "100111010000";
        System.out.println("Двоичное число " + binaryNumber + " равно шестнадцатеричному числу " + toHex(binaryNumber));
        String hexNumber = "9d0";
        System.out.println("Шестнадцатеричное число " + hexNumber + " равно двоичному числу " + toBinary(hexNumber));
    }

    public static String toHex(String binaryNumber) {
        //напишите тут ваш код
        String res = "";
        if (binaryNumber != null){

            for (int i = 0; i < binaryNumber.length() % 4; i++) {
                binaryNumber = "0" + binaryNumber;
            }

            for (int i = 0; i < binaryNumber.length(); i+=4) {
                int position = Arrays.binarySearch(dataBIN, binaryNumber.substring(i,i+4));
                if (position < 0) return "";
                res += dataHEX.charAt(position);

            }
        }

        return res;
    }

    public static String toBinary(String hexNumber) {
        //напишите тут ваш код

        String res = "";
        if (hexNumber != null){
            for (int i = 0; i < hexNumber.length(); i++) {
                int position = dataHEX.indexOf(hexNumber.charAt(i));
                if (position < 0) return "";
                res += dataBIN[position];
            }
        }

        return res;
    }
}
