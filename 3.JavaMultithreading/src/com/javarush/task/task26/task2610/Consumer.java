package com.javarush.task.task26.task2610;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
    private BlockingQueue queue;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        //try {
            int i = 0;
            while (true) {
                Object item = queue.poll();
                if (item != null)
                    System.out.println(item);
                //Thread.sleep(300);
            }
//        } catch (InterruptedException e) {
//            System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
//        }
    }
}
