package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
    }

    public static int getRectangleCount(byte[][] a) {

        AllRectangle pole = new AllRectangle();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == 1)
                    pole.addPoint(i, j);
            }
        }

        return pole.rectangles.size();
    }

    public static class Rectangle{
        public int minI;
        public int minJ;

        public int maxI;
        public int maxJ;

        public Rectangle(int i, int j){
            this.maxI = i;
            this.maxJ = j;

            this.minI = i;
            this.minJ = j;
        }

        public boolean addPoint(int i, int j){
            if (maxJ + 1 >= j && minJ - 1 <= j && maxI + 1 >= i && minI - 1 <= i){
                if (maxI < i) maxI = i;
                if (minI > i) minI = i;
                if (maxJ < j) maxJ = j;
                if (minJ > j) minJ = j;
                return true;
            }
            return false;
        }

    }

    public static class AllRectangle{
        public List<Rectangle> rectangles;

        public AllRectangle(){
            rectangles = new ArrayList<>();
        }

        public void addPoint(int i, int j){
            boolean find = false;
            for (Rectangle unit : rectangles){
                if (unit.addPoint(i,j)){
                    find = true;
                    break;
                }
            }
            if (!find){
                rectangles.add(new Rectangle(i, j));
            }

        }

    }
}
