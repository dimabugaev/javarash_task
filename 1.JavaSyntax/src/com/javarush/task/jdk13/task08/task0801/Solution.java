package com.javarush.task.jdk13.task08.task0801;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Set из растений
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Set<String> set = new HashSet<>();

        set.add("арбуз");
        set.add("банан");
        set.add("вишня");
        set.add("груша");
        set.add("дыня");
        set.add("ежевика");
        set.add("женьшень");
        set.add("земляника");
        set.add("ирис");
        set.add("картофель");

        Iterator iter = set.iterator();

        while (iter.hasNext()){
            System.out.println(iter.next());
        }

    }
}
