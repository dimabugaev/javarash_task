package com.javarush.task.task29.task2912;

public class FileLogger extends AbstractLogger {

    public FileLogger(int level) {
        super(level);
    }

    @Override
    String getPlaceToLogging() {
        return "Logging to file: ";
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
//        System.out.println("Logging to file: " + message);
//    }
}