package com.javarush.task.jdk13.task09.task0926;

import java.util.ArrayList;
import java.util.Arrays;

/* 
Список из массивов чисел
*/

public class Solution {

    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        //напишите тут ваш код
        ArrayList<int[]> res = new ArrayList<>();
        int[] data = new int[]{5, 2, 4, 7, 0};
        for (int i = 0; i < data.length; i++) {
            res.add(i, new int[data[i]]);
            for (int j = 0; j < data[i]; j++) {
                res.get(i)[j] = (int) (Math.random()*100);
            }
        }

        return res;
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            System.out.println(Arrays.toString(array));
        }
    }
}
