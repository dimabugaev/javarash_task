package com.javarush.task.task13.task1326;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = null;
        FileInputStream freader = null;
        List<Integer> list = new ArrayList<>();

        try{
            reader = new BufferedReader(new InputStreamReader(System.in));
            freader = new FileInputStream(reader.readLine());

            Scanner scanfile = new Scanner(freader);

            while (scanfile.hasNext()){
                int value = Integer.parseInt(scanfile.nextLine());
                if (value % 2 == 0) list.add(value);
            }
                //System.out.println(scanfile.nextLine());

        }catch (Exception e){
            System.out.println(e);
        }finally {
            if (reader != null)
                reader.close();
            if (freader != null)
                freader.close();
        }

        Collections.sort(list);
        for(Integer value: list){
            System.out.println(value);
        }
    }
}
