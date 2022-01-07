package com.javarush.task.task28.task2803;

import java.util.concurrent.ThreadLocalRandom;

/* 
ThreadLocalRandom
*/

public class Solution {
    public static synchronized int getRandomIntegerBetweenNumbers(int from, int to) {

        return ThreadLocalRandom.current().nextInt(from, to);
    }

    public static synchronized double getRandomDouble() {
        return ThreadLocalRandom.current().nextDouble();
    }

    public static synchronized long getRandomLongBetween0AndN(long n) {
        return ThreadLocalRandom.current().nextLong(n);
    }

    public static void main(String[] args) {
    }
}
