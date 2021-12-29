package com.javarush.task.task22.task2209;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/* 
Составить цепочку слов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //...

        try(BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
            FileInputStream fileInputStream = new FileInputStream(console.readLine());
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {

            byte[] buf = new byte[200];
            while (fileInputStream.available() > 0){
                int count = fileInputStream.read(buf);
                byteArrayOutputStream.write(buf, 0, count);
            }

            String[] dataFile = byteArrayOutputStream.toString().split("\\s");
            StringBuilder result = getLine(dataFile);
            System.out.println(result.toString());
        }

    }

    public static StringBuilder getLine(String... words) {


        if (words == null || words.length == 0)
            return new StringBuilder();

        int[] indexArray = new int[words.length];

        while (true) {

            if (checkIndex(indexArray)) {
                int pastK = 0;
                StringBuilder res = new StringBuilder(words[indexArray[pastK]]).append(" ");

                for (int k = 1; k < words.length; k++) {

                    if (Character.toLowerCase(words[indexArray[pastK]].charAt(words[indexArray[pastK]].length() - 1)) ==
                            Character.toLowerCase(words[indexArray[k]].charAt(0)))
                        res.append(words[indexArray[k]]).append(" ");
                    else
                        break;

                    pastK++;
                }

                if (pastK == words.length - 1)
                    return res;
            }

            int j = words.length - 1;
            while (j >= 0 && indexArray[j] == words.length - 1) {
                indexArray[j] = 0;
                j--;
            }
            if (j < 0) break;
            indexArray[j]++;
        }


        return new StringBuilder();
    }

    public static boolean checkIndex(int[] index){
        for (int i = 0; i < index.length; i++) {
            for (int j = i + 1; j < index.length; j++) {
                if (index[i] == index[j]) return false;
            }
        }
        return true;
    }
}
