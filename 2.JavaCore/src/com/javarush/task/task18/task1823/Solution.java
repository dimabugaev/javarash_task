package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String line = reader.readLine();
            if (line.equals("exit")) break;

            new ReadThread(line).start();
        }
    }

    public static class ReadThread extends Thread {
        private String fileName;
        private FileReader reader;

        public ReadThread(String fileName) throws FileNotFoundException {
            //implement constructor body
            this.fileName = fileName;
            reader = new FileReader(fileName);
        }

        @Override
        public void run() {
            Map<Integer, Integer> seekMax = new HashMap<>();

            try {
                int i;
                while ((i = reader.read()) > 0){
                    if (seekMax.containsKey(i))
                        seekMax.put(i, seekMax.get(i) + 1);
                    else
                        seekMax.put(i, 1);
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            int maxVal = -1;
            int result = -1;

            for(Map.Entry<Integer, Integer> pair: seekMax.entrySet()){
                if (pair.getValue() > maxVal){
                    maxVal = pair.getValue();
                    result = pair.getKey();
                }
            }

            if (result > 0)
            {
                synchronized (Solution.class){
                    if (!resultMap.containsKey(this.fileName))
                        resultMap.put(fileName, result);
                }
            }
        }

        // implement file reading here - реализуйте чтение из файла тут
    }
}
