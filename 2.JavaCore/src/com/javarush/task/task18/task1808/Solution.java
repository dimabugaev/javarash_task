package com.javarush.task.task18.task1808;

import java.io.*;

/* 
Разделение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        String fileName3 = reader.readLine();

        FileInputStream fileInputStream = new FileInputStream(fileName1);
        FileOutputStream fileOut2 = new FileOutputStream(fileName2);
        FileOutputStream fileOut3 = new FileOutputStream(fileName3);

        if (fileInputStream.available() > 0)
        {
            byte[] buf = new byte[fileInputStream.available()];
            int count = fileInputStream.read(buf);
            if (count > 0){
                fileOut2.write(buf, 0, count/2 + count%2);
            }

            if (count > 1){

                fileOut3.write(buf, count/2 + count%2, count - (count/2 + count%2));
            }

        }
        fileInputStream.close();
        fileOut2.close();
        fileOut3.close();


    }
}
