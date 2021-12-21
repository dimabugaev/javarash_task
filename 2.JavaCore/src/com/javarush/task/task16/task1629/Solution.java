package com.javarush.task.task16.task1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Только по-очереди!
*/

public class Solution {
    public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws InterruptedException {
        Read3Strings t1 = new Read3Strings();
        Read3Strings t2 = new Read3Strings();
        t1.start();
        t1.join();
        t2.start();
        //add your code here - добавьте код тут
        t2.join();
        t1.printResult();
        t2.printResult();
    }

    //add your code here - добавьте код тут

    public static class Read3Strings extends Thread{
        public static final byte COUNT = 3;
        List<String> result = new ArrayList<>(COUNT);

        @Override
        public void run() {
            try {
                for (int i = 0; i < COUNT; i++) {
                    result.add(reader.readLine());
                }
            } catch (IOException e) {

            }
        }

        @Override
        public String toString() {
            String res = "";
            for(String line: result){
                res += line + " ";
            }
            return res;
        }

        public void printResult(){
            System.out.println(this);
        }
    }
}
