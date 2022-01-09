package com.javarush.task.task29.task2912;

public class SmsLogger extends AbstractLogger {

    public SmsLogger(int level) {
        super(level);
    }


    @Override
    String getPlaceToLogging() {
        return "Send SMS to CEO: ";
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
//        System.out.println("Send SMS to CEO: " + message);
//    }
}