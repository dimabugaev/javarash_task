package com.javarush.task.task30.task3003;

import java.util.concurrent.TransferQueue;

public class Consumer implements Runnable {

    private TransferQueue<ShareItem> queue;

    public Consumer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(450);
        } catch (InterruptedException e) {
            //
        }

        Thread current = Thread.currentThread();

        while (!current.isInterrupted()){
            try {
                ShareItem item = queue.take();
                //System.out.println("Processing "+ item.toString());
                System.out.format("Processing %s\n", item.toString());
            } catch (InterruptedException e) {
                //
            }
        }
    }
}
