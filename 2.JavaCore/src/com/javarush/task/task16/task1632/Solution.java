package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Клубок
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new Infinity());
        threads.add(new Exep());
        threads.add(new SayUra());
        threads.add(new MyMessage());
        threads.add(new ReadMe());

    }

    public static void main(String[] args){


    }

    public static class Infinity extends Thread{

        @Override
        public void run() {

            while (true){
                //Thread.sleep(200);
            }
        }
    }

    public static class Exep extends Thread{
        @Override
        public void run() {

            //while (!isInterrupted()){
                try {
                    throw new InterruptedException();
                }catch (InterruptedException e){
                    System.out.println(e);
                  //  interrupt();
                }
            //}
        }
    }

    public static class SayUra extends Thread{
        @Override
        public void run() {

            while (true) {

                try {
                    System.out.println("Ура");
                    Thread.sleep(500);

                } catch (InterruptedException e) {
                }
            }
        }
    }

    public static class MyMessage extends Thread implements Message {
        public void run() {
            while (!isInterrupted()) {

            }
        }

        public void showWarning() {
            this.interrupt();
        }
    }

    public static class ReadMe extends Thread{
        @Override
        public void run() {

            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                double sum = 0;
                while (true){
                    String line = reader.readLine();
                    if ("N".equals(line)) {
                        System.out.println(sum);
                        break;
                    }

                    try {
                        sum += Double.parseDouble(line);
                    }catch (NumberFormatException e){}

                }
                reader.close();
            }catch (IOException e){}

        }
    }
}