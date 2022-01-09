package com.javarush.task.task30.task3001;

import java.math.BigInteger;

/* 
Конвертер систем счислений
*/

public class Solution {
    public static void main(String[] args) {
        Number number = new Number(NumberSystemType._10, "6");
        Number result = convertNumberToOtherNumberSystem(number, NumberSystemType._2);
        System.out.println(result);    //expected 110

        number = new Number(NumberSystemType._16, "6df");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._8);
        System.out.println(result);    //expected 3337

//        number = new Number(NumberSystemType._8, "6df");
//        result = convertNumberToOtherNumberSystem(number, NumberSystemType._8);
//        System.out.println(result);    //expected 3337

        number = new Number(NumberSystemType._16, "abcdefabcdef");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._16);
        System.out.println(result);    //expected abcdefabcdef
    }

    public static Number convertNumberToOtherNumberSystem(Number number, NumberSystem expectedNumberSystem) {
        number.checkCorrect();
        if (number.getNumberSystem().equals(expectedNumberSystem))
            return number;
        else {
            BigInteger a = new BigInteger(number.getDigit(), number.getNumberSystem().getNumberSystemIntValue());
            String buf = a.toString(expectedNumberSystem.getNumberSystemIntValue());
            Number res = new Number(expectedNumberSystem, buf);
            return res;
        }
        //напишите тут ваш код
        //return null;
    }
}
