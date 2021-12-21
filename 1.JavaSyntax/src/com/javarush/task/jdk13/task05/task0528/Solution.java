package com.javarush.task.jdk13.task05.task0528;

import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Вывести на экран сегодняшнюю дату
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Date nowDate = new Date();
        SimpleDateFormat fDate = new SimpleDateFormat("dd MM yyyy");

        System.out.println(fDate.format(nowDate));

    }
}
