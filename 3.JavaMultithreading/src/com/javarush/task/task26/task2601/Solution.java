package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Comparator;

/* 
Почитать в инете про медиану выборки
*/

public class Solution {

    public static void main(String[] args) {

//        Integer[] test = new Integer[]{13, 8, 15, 5, 17};
//        System.out.println(sort(test));

    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        Integer[] sorted = Arrays.copyOf(array, array.length);
        Arrays.sort(sorted);
        double med = 0;
        if (sorted.length % 2 == 0)
            med = (double) (sorted[sorted.length/2 - 1] + sorted[sorted.length/2])/2;
        else
            med = (double) sorted[sorted.length/2];

        final double mediana = med;

        Comparator<Integer> compareToArrayMediana = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int res = (int)(Math.abs(mediana - o1) - Math.abs(mediana - o2));
                if (res == 0)
                    res = o1 - o2;
                return res;
            }
        };

        Arrays.sort(array, compareToArrayMediana);

        return array;
    }

}
