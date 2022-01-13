package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.Waiter;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant {

    private static final int ORDER_CREATING_INTERVAL = 100;
    private static final LinkedBlockingQueue<Order> ORDER_QUEUE = new LinkedBlockingQueue<>();

    public static void main(String[] args) throws InterruptedException {
        Cook cook = new Cook("Vasserman Ivanovich");
        Waiter waiter = new Waiter();
        cook.addObserver(waiter);
        cook.setQueue(ORDER_QUEUE);

        Thread tcook1 = new Thread(cook);

        Cook cook2 = new Cook("Kote");
        cook2.addObserver(waiter);
        cook2.setQueue(ORDER_QUEUE);

        Thread tcook2 = new Thread(cook2);

        tcook1.start();
        tcook2.start();

        List<Tablet> tabletList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Tablet tablet = new Tablet(i + 1);
            //tablet.addObserver(orderManager);
            tablet.setQueue(ORDER_QUEUE);
            tabletList.add(tablet);
        }


        Thread thread = new Thread(new RandomOrderGeneratorTask(tabletList, ORDER_CREATING_INTERVAL));
        thread.start();

        Thread.sleep(1000);

        thread.interrupt();
        thread.join();

//        Tablet tablet = new Tablet(1);
//        tablet.addObserver(cook);
//        tablet.createOrder();
//
//        Tablet tablet2 = new Tablet(2);
//        tablet2.addObserver(cook2);
//        tablet2.createOrder();

//        tablet.createOrder();
//        tablet.createOrder();
//        tablet.createOrder();

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        ConsoleHelper.writeMessage("");
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();

    }
}
