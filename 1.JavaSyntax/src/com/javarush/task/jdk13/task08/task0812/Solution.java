package com.javarush.task.jdk13.task08.task0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* 
Cамая длинная последовательность
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> integers = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            integers.add(Integer.parseInt(reader.readLine()));
        }

        int teklen = 1;
        int maxlen = 1;
        for (int i = 1; i < integers.size(); i++) {
            if (Objects.equals(integers.get(i), integers.get(i - 1))){
                teklen += 1;
            }
            else {
                teklen = 1;
            }
            if (teklen > maxlen){
                maxlen = teklen;
            }
        }

        System.out.println(maxlen);

    }
}
