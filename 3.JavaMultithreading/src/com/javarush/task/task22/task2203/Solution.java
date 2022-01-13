package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/

public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        String res = null;
        try {

            int start = 0;
            int end = 0;
            start = string.indexOf('\t');
            end = string.indexOf('\t', start + 1);

            res = string.substring(start+1, end);
        }catch (Exception e){
            throw new TooShortStringException();
        }

        return res;
    }

    public static class TooShortStringException extends Exception {

    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
