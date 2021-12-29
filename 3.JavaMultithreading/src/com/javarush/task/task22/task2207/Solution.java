package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/

public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        try(BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(console.readLine());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            //String[] dataFile = fileInputStream.readAllBytes().toString().split(" ");

            byte[] buf = new byte[200];
            while (fileInputStream.available() > 0){
                int count = fileInputStream.read(buf);
                byteArrayOutputStream.write(buf, 0, count);
            }

            String[] dataFile = byteArrayOutputStream.toString().split("\\s");

            List <Integer> addedIndexes = new ArrayList<>();

            for (int i = 0; i < dataFile.length; i++) {
                if (addedIndexes.indexOf(i) > 0) continue;
                StringBuilder seekString = new StringBuilder(dataFile[i]);
                String toComp = seekString.reverse().toString();
                for (int j = i + 1; j < dataFile.length; j++) {
                    if (addedIndexes.indexOf(j) > 0) continue;

                    if (toComp.equals(dataFile[j])){
                        result.add(new Pair(dataFile[i], dataFile[j]));
                        addedIndexes.add(i);
                        addedIndexes.add(j);
                        break;
                    }
                }
            }
        }

        for(Pair pair: result){
            System.out.println(pair);
        }
    }

    public static class Pair {
        String first;
        String second;

        public Pair() {
        }

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
