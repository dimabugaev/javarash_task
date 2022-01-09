package com.javarush.task.task29.task2912;

public class PhoneLogger extends AbstractLogger {

    public PhoneLogger(int level) {
        super(level);
    }


    @Override
    String getPlaceToLogging() {
        return "Call to director: ";
    }

//    @Override
//    public void inform(String message, int level) {
//        if (this.level <= level) {
//            info(message);
//        }
//        if (next != null) {
//            next.inform(message, level);
//        }
//    }
//
//    @Override
//    public void setNext(Logger next) {
//        this.next = next;
//    }
//
//    @Override
//    public void info(String message) {
//        System.out.println("Call to director: " + message);
//    }
}