package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("Амиго и Диего лучшие друзья!"));
    }

    public static String getPartOfString(String string) {
        int startIndex = 0;
        int start = 0;
        int middle = 0;
        int end = 0;
        String res = null;
        try {
            for (int i = 0; i < 5; i++) {
                startIndex = string.indexOf(' ', startIndex);
                if (i == 0)
                    start = startIndex;
                if (i == 3)
                    middle = startIndex;
                if (i == 4) {
                    end = startIndex;
                    if (end < 0 && middle > 0)
                        end = string.length();
                }
                startIndex++;
            }


            res = string.substring(start+1, end);
        }catch (Exception e){
            throw new TooShortStringException();
        }


        return res;
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
