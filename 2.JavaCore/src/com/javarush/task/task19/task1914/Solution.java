package com.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Решаем пример
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream oldOut = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream newOut = new PrintStream(outputStream);

        System.setOut(newOut);

        testString.printSomething();

        String res = outputStream.toString().trim();
        String[] comp = res.split(" ");
        if (comp[1].trim().equals("+"))
            res = res + " " + (Integer.parseInt(comp[0]) + Integer.parseInt(comp[2]));
        else if (comp[1].trim().equals("-"))
            res = res + " " + (Integer.parseInt(comp[0]) - Integer.parseInt(comp[2]));
        else if (comp[1].trim().equals("*"))
            res = res + " " + (Integer.parseInt(comp[0]) * Integer.parseInt(comp[2]));

        System.setOut(oldOut);

        System.out.println(res);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

