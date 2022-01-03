package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread{
    Thread target;

    public LoggingStateThread(Thread target) {
        this.target = target;
        this.setDaemon(true);
    }

    @Override
    public void run() {
        State state = null;
        while (true) {
            if (state != target.getState()){
                state = target.getState();
                System.out.println(state);
            }
            if (state == State.TERMINATED)
                break;
        }
    }
}
