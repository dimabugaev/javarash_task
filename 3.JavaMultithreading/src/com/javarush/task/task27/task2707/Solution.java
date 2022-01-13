package com.javarush.task.task27.task2707;

/* 
Определяем порядок захвата монитора
*/

public class Solution {
    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
        synchronized (obj1) {
            synchronized (obj2) {
                System.out.println(obj1 + " " + obj2);
            }
        }
    }

    public static boolean isLockOrderNormal(final Solution solution, final Object o1, final Object o2) throws Exception {
        //do something here
        Thread threadCheck1 = new Thread(){
            @Override
            public void run() {
                synchronized (o1) {
                    try {Thread.sleep(200);
                    } catch (InterruptedException e) {}

                    synchronized (o2) {
                        try {Thread.sleep(200);
                        } catch (InterruptedException e) {}
                    }
                }
            }
        };

        Thread threadCheck2 = new Thread(){
            @Override
            public void run() {
                solution.someMethodWithSynchronizedBlocks(o1, o2);
            }
        };

        threadCheck1.start();
        threadCheck2.start();

        try {Thread.sleep(500);
        } catch (InterruptedException e) {}

        if (threadCheck2.getState() == Thread.State.BLOCKED) {
            threadCheck1.interrupt();
            threadCheck2.interrupt();
            return false;
        }
        else
            return true;
    }

    public static void main(String[] args) throws Exception {
        final Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();

        System.out.println(isLockOrderNormal(solution, o1, o2));
    }
}
