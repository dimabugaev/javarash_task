package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(74);

    }

    public void createExpression(int number) {
        //напишите тут ваш код
        System.out.printf("%s = ", number);
        int pow = 0;
        while (number > 0){
            switch (number % 3) {
                case 0:
                    number = number /3;
                    break;
                case 1:
                    number = number /3;
                    System.out.printf(" + %s", (int) Math.pow(3, pow));
                    break;
                case 2:
                    number = number /3 + 1;
                    System.out.printf(" - %s", (int) Math.pow(3, pow));
                    break;
            }
            pow++;
        }
    }
}