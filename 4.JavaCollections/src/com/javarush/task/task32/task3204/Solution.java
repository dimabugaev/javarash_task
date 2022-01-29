package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;

/* 
Генератор паролей
*/

public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8);


        while (!byteArrayOutputStream.toString().matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$")){
            byteArrayOutputStream.reset();
            for (int i = 0; i < 8; i++) {
                byteArrayOutputStream.write((int) (Math.random() * 127));
            }
        }


        return byteArrayOutputStream;
    }
}
