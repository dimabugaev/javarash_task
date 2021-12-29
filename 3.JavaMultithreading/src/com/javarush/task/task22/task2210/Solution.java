package com.javarush.task.task22.task2210;

import java.util.StringTokenizer;

/* 
StringTokenizer
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static String[] getTokens(String query, String delimiter) {
        StringTokenizer st = new StringTokenizer(query, delimiter);
        String[] res = new String[st.countTokens()];
        int i = 0;
        while (st.hasMoreElements()){
            res[i] = st.nextToken();
            i++;
        }

        return res;
    }
}
