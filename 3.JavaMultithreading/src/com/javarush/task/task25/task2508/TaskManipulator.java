package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    private Thread nowStarted;

    @Override
    public void run() {
        //Thread current = Thread.currentThread();

        //while (!current.isInterrupted()){
        while (!nowStarted.isInterrupted()){
            //System.out.println(current.getName());
            System.out.println(nowStarted.getName());

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                //throw new RuntimeException();
            }

        }
    }

    @Override
    public void start(String threadName) {

        nowStarted = new Thread(this, threadName);
        nowStarted.start();

    }

    @Override
    public void stop() {
        if (nowStarted != null)
            nowStarted.interrupt();
    }
}
