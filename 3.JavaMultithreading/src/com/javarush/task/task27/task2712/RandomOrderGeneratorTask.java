package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.Tablet;

import java.util.List;

public class RandomOrderGeneratorTask implements Runnable{
    private List<Tablet> tabletList;
    private int interval;

    public RandomOrderGeneratorTask(List<Tablet> tabletList, int interval) {
        this.tabletList = tabletList;
        this.interval = interval;
    }

    @Override
    public void run() {
        while (true) {
            try {
                tabletList.get((int) (Math.random() * tabletList.size())).createTestOrder();
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
