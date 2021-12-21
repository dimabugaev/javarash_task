package com.javarush.task.jdk13.task07.task0716;

import java.util.ArrayList;

/* 
Р или Л
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("роза");
        strings.add("лоза");
        strings.add("лира");
        strings = fix(strings);

        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> strings) {
        //напишите тут ваш код
        for (int i = 0; i < strings.size(); i++) {
            boolean isR = (strings.get(i).indexOf("р") >= 0);
            boolean isL = (strings.get(i).indexOf("л") >= 0);
            if ((isL && isR) || (!isL && !isR)){
                continue;
            }
            if (isL) {
                strings.add(i+1, strings.get(i));
                i++;

            }
            if (isR) {
                strings.remove(i);
                i--;
            }
        }
        return strings;
    }
}