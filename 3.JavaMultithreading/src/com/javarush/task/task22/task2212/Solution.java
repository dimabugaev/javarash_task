package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/

public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null) return false;
        return telNumber.matches("(\\+\\d{12})|(\\+\\d{2}\\(\\d{3}\\)\\d{7})|(\\(\\d{3}\\)\\d{7})|(\\d\\(\\d{3}\\)\\d{6})|(\\d{10})|(\\d{2}\\(\\d{3}\\)\\d{5})|(\\d{3}\\(\\d{3}\\)\\d{4})|(\\d{4}\\(\\d{3}\\)\\d{3})|(\\d{5}\\(\\d{3}\\)\\d{2})|(\\d{6}\\(\\d{3}\\)\\d)");
    }

    public static void main(String[] args) {

    }
}
