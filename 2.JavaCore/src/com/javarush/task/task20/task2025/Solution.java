package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* 
Алгоритмы-числа
*/

public class Solution {

    public static long[][] pow = new long[10][20];
    private static int[] intArray;

    public static long[] getNumbers(long N) {
        ArrayList<Long> list = new ArrayList<>();

        getPow();
        initArray(N);

        //for (long i = 1; i <= N; i++) {
        //int M = intArray.length;
        while(true) {
            int index = 0;
            while (true) {
                int M = intArray.length - index;

                long res = 0;
                for (int i = 0; i < intArray.length; i++) {
                    res = res + pow[intArray[i]][M - 1];
                }

                if (res < N && compareFromArray(res, index))
                    list.add(res);

                if (index < intArray.length && intArray[index] == 0)
                    index++;
                else
                    break;
            }

            if(!decrementArray())
                break;
        }


        long[] result = new long[list.size()];
        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    public static void initArray(long number) {
        int count = (number == 0) ? 1 : 0;
        //List<Byte> num = new ArrayList<>();
        while (number != 0) {
            count++;
            //num.add((byte) (number % 10));
            number /= 10;
        }

        intArray = new int[count];
        Arrays.fill(intArray, 9);

        //return num;
    }

    //private static int[] intArray = { 9, 9, 9, 9, 9, 9 };

    private static boolean decrementArray() {
        int index = 0;

        while (index < intArray.length && intArray[index] == 0) {
            index++;
        }

        if (index + 1 == intArray.length && intArray[index] == 1) {
            return false;
        }

        Arrays.fill(intArray, 0, index + 1, intArray[index] - 1);
        return true;
    }

    public static void getPow()
    {
        for (int i = 0; i < pow.length; i++) {
            for (int j = 0; j < pow[i].length; j++) {
                pow[i][j] = i;
                for (int k = 0; k < j; k++) {
                    pow[i][j] *= i;
                }
            }
        }
    }

    public static boolean compareFromArray(long N, int index){
        if (N == 0) return false;

//        int index = 0;
//        while (index < intArray.length && intArray[index] == 0) {
//            index++;
//        }

        List<Integer> num = new ArrayList<>();
        while (N != 0) {
            num.add((int) (N % 10));
            N /= 10;
        }

        for (int i = index; i < intArray.length; i++) {
            int find = num.indexOf(intArray[i]);
            if (find < 0)
                return false;
            else
                num.remove(find);
        }
        if (num.size() == 0)
            return true;
        else
            return false;
    }

    public static int getLength(){
        int delta = 0;
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] == 0)
                delta ++;
            else
                break;
        }
        return intArray.length - delta;
    }

    public static void main(String[] args) {

        //getPow();
        //initArray(23456789);

        //getFromArray();
        //getNumbers(1000);
        //getCountsOfDigits(23456789);

        long a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000)));
        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);

        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(Long.MAX_VALUE)));
        //System.out.println(Arrays.toString(getNumbers(1000000000)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);
    }
}
