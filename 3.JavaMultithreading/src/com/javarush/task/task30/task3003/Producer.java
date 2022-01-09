package com.javarush.task.task30.task3003;

import java.util.concurrent.TransferQueue;

public class Producer implements Runnable {

    private TransferQueue<ShareItem> queue;

    public Producer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        Thread current = Thread.currentThread();
        //while (!current.isInterrupted()){
            for (int i = 0; i < 9; i++) {
                //System.out.println("Элемент 'ShareItem-"+(i+1)+"' добавлен");
                System.out.format("Элемент 'ShareItem-%d' добавлен\n", (i+1));
                queue.offer(new ShareItem("ShareItem-"+(i+1), (i+1)));

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    //
                }

                if (queue.hasWaitingConsumer())
                    System.out.format("Consumer в ожидании!\n");

            }

        //}
    }
}
