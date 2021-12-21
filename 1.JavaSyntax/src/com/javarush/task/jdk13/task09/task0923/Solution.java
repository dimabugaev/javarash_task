package com.javarush.task.jdk13.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/* 
Гласные и согласные буквы
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] dataStr = reader.readLine().replaceAll(" ","").toCharArray();
        ArrayList<Character> second = new ArrayList<>();


        for (int i = 0; i < dataStr.length; i++) {
            if (isVowel(dataStr[i])) {
                System.out.print(dataStr[i] + " ");
            }else second.add(dataStr[i]);
        }
        System.out.println();
        second.forEach(value -> System.out.print(value + " "));



    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char character) {
        character = Character.toLowerCase(character);  // приводим символ в нижний регистр - от заглавных к строчным буквам
        for (char vowel : vowels) {  // ищем среди массива гласных
            if (character == vowel) {
                return true;
            }
        }
        return false;
    }
}