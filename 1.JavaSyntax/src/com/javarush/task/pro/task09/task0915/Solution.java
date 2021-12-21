package com.javarush.task.pro.task09.task0915;

import java.util.Arrays;
import java.util.StringTokenizer;

/* 
StringTokenizer
*/

public class Solution {
    public static void main(String[] args) {
        String packagePath = "java.util.stream";
        String[] tokens = getTokens(packagePath, ".");
        System.out.println(Arrays.toString(tokens));
    }

    public static String[] getTokens(String query, String delimiter) {
        //напишите тут ваш код
        StringTokenizer work = new StringTokenizer(query, delimiter);
        String[] res = new String[work.countTokens()];
        int i = 0;
        while (work.hasMoreTokens()){
            res[i] = work.nextToken();
            i++;
        }

        return res;
    }
}
