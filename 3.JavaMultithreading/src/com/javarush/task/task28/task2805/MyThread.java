package com.javarush.task.task28.task2805;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread{
    private static AtomicInteger prior = new AtomicInteger(MIN_PRIORITY);

    public MyThread() {
        super();
        setPriorites();
    }

    public MyThread(Runnable target) {
        super(target);
        setPriorites();
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        setPriorites();
    }

    public MyThread(String name) {
        super(name);
        setPriorites();
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        setPriorites();
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        setPriorites();
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        setPriorites();
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        setPriorites();
    }

//    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize, boolean inheritThreadLocals) {
//        super(group, target, name, stackSize, inheritThreadLocals);
//        setPriorites();
//    }

    private void setPriorites(){
        //int valuePr = prior.get();
        //if (this.getThreadGroup() != null)
        //    valuePr = Math.min(this.getThreadGroup().getMaxPriority(),valuePr);

        this.setPriority(prior.get());

        if (prior.get() < MAX_PRIORITY)
            prior.incrementAndGet();
        else
            prior.set(MIN_PRIORITY);
    }
}
