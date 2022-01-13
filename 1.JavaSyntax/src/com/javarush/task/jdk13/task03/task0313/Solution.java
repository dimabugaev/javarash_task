package com.javarush.task.jdk13.task03.task0313;

/* 
Мама мыла раму
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        String[] combo = "Мама Мыла Раму".split(" ");
        for (int i = 0; i < combo.length; i++) {
            for (int j = 0; j < combo.length; j++) {
                for (int k = 0; k < combo.length; k++) {
                    if (i == j || j == k || i == k) continue;
                    System.out.printf("%s%s%s\n",combo[i], combo[j], combo[k]);
                }
            }
        }
    }
}
