package com.javarush.task.task19.task1915;

import java.io.*;

/* 
Дублируем текст
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        PrintStream oldOut = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream newOut = new PrintStream(outputStream);

        System.setOut(newOut);

        testString.printSomething();

        String res = outputStream.toString();
        System.setOut(oldOut);

        FileOutputStream outFile = new FileOutputStream(reader.readLine());
        reader.close();

        outFile.write(res.getBytes());
        outFile.close();
        System.out.println(res);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

