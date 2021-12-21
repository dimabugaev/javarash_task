package com.javarush.task.jdk13.task07.task0707;

import java.util.ArrayList;

/* 
5 различных строк в списке
*/

public class Solution {
    
    public static ArrayList<String> list;
    
    public static void main(String[] args) {
        //напишите тут ваш код
        list = new ArrayList<String>();
        list.add("kjhdsfsd");
        list.add("string 2");
        list.add("privett");
        list.add("krevet");
        list.add("poka");

        System.out.println(list.size());

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }


    }
}
