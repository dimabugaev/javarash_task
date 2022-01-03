package com.javarush.task.task25.task2512;

import java.util.LinkedList;
import java.util.List;

/* 
Живем своим умом
*/

public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        //System.out.println(t.getName());
        printStack(e);
        t.interrupt();
    }

    private void printStack(Throwable e){
        if (e != null)
            printStack(e.getCause());
        else
            return;
        System.out.println(e);
    }

    public static void main(String[] args) {
        new Solution().uncaughtException(new Thread(), new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI"))));

    }
}
