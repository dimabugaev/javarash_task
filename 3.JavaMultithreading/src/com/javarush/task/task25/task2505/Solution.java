package com.javarush.task.task25.task2505;

/* 
Без дураков
*/

public class Solution {

    public static void main(String[] args) {
        MyThread myThread = new Solution().new MyThread("super secret key");
        myThread.start();
    }

    public class MyThread extends Thread {
        private String secretKey;

        public MyThread(String secretKey) {
            this.secretKey = secretKey;
            setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
            //setDaemon(true);
        }

        @Override
        public void run() {
            //throw new NullPointerException("it's an example");
            //throw new NullPointerException("Blah " + Thread.currentThread().getName() + " blah-blah-blah");
            try {
                throw new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")));
            } catch (Exception e) {
                //e.printStackTrace();
            }
        }

        private class MyUncaughtExceptionHandler implements UncaughtExceptionHandler{

            public MyUncaughtExceptionHandler() {
                //System.out.println("test1");
            }

            @Override
            public void uncaughtException(Thread t, Throwable e) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    //ex.printStackTrace();
                }

                String newName = t.getName().replaceAll(".", "*");
                System.out.println(e.getMessage().replaceAll(t.getName(), newName));

                System.out.println(String.format("%s, %s, %s", secretKey, t.getName(), e.getMessage()));
            }
        }
    }

}

