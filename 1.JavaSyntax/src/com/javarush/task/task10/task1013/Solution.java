package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/


public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // Напишите тут ваши переменные и конструкторы
        private int count;
        private byte continents;
        private float longLife;
        private double saintenst;
        private boolean isGood;
        private short statistic;

        public Human(int count){}
        public Human(int count, byte continents) {}
        public Human(int count, byte continents, float longLife) {}
        public Human(int count, byte continents, float longLife, double saintenst) {}
        public Human(int count, byte continents, float longLife, double saintenst, boolean isGood) {}
        public Human(int count, byte continents, float longLife, double saintenst, boolean isGood, short statistic) {}
        public Human(int count, float longLife, double saintenst, boolean isGood, short statistic) {}
        public Human(int count, double saintenst, boolean isGood, short statistic) {}
        public Human(int count, boolean isGood, short statistic) {}
        public Human(int count, short statistic) {}


    }
}
