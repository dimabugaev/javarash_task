package com.javarush.task.pro.task09.task0914;

/* 
Обновление пути
*/

public class Solution {
    public static void main(String[] args) {
        String path = "/usr/java/jdk1.8/bin/";

        String jdk13 = "jdk-13";
        System.out.println(changePath(path, jdk13));
    }

    public static String changePath(String path, String jdk) {
        //напишите тут ваш код
        int start = path.indexOf("jdk");
        if (start > 0){
            int stop = path.indexOf('/',start);
            if (stop > 0) return path.replaceFirst(path.substring(start,stop),jdk);
        }

        return null;
    }
}
