package com.javarush.task.task16.task1603;

import java.util.ArrayList;
import java.util.List;

/* 
Список и нити
*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<Thread>(5);

    public static void main(String[] args) {
        //напишите тут ваш код
        for (int i = 0; i < 5; i++) {
            list.add(new Thread(new SpecialThread()));
        }
//
//
//        for (Thread thread : list) {
//            thread.start();
//        }
//        SpecialThread obj1 = new SpecialThread();
//        SpecialThread obj2 = new SpecialThread();
//        SpecialThread obj3 = new SpecialThread();
//        SpecialThread obj4 = new SpecialThread();
//        SpecialThread obj5 = new SpecialThread();
//
//        list.add(new Thread(obj1));
//        list.add(new Thread(obj2));
//        list.add(new Thread(obj3));
//        list.add(new Thread(obj4));
//        list.add(new Thread(obj5));

    }

    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("it's a run method inside SpecialThread");
        }
    }
}
