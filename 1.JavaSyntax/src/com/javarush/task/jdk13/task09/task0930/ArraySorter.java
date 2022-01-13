package com.javarush.task.jdk13.task09.task0930;

import java.util.ArrayList;

public class ArraySorter {

    public void sort(String[] array) {
        //напишите тут ваш код

        ArrayList<Integer> indexWord = new ArrayList<>();
        ArrayList<Integer> indexCount = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            if (isNumber(array[i])) indexCount.add(i);
            else indexWord.add(i);
        }

        for (int i = 0; i < indexCount.size(); i++) {
            for (int j = i + 1; j < indexCount.size(); j++) {
                if (Integer.parseInt(array[indexCount.get(i)]) < Integer.parseInt(array[indexCount.get(j)])){
                    String buf = array[indexCount.get(j)];
                    array[indexCount.get(j)] = array[indexCount.get(i)];
                    array[indexCount.get(i)] = buf;
                }
            }
        }

        for (int i = 0; i < indexWord.size(); i++) {
            for (int j = i + 1; j < indexWord.size(); j++) {
                if (isGreaterThan(array[indexWord.get(i)],array[indexWord.get(j)])){
                    String buf = array[indexWord.get(j)];
                    array[indexWord.get(j)] = array[indexWord.get(i)];
                    array[indexWord.get(i)] = buf;
                }
            }
        }
    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public boolean isNumber(String text) {
        if (text.length() == 0) {
            return false;
        }

        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char character = chars[i];
            if ((i != 0 && character == '-') // Строка содержит '-'
                    || (!Character.isDigit(character) && character != '-') // или не цифра и не начинается с '-'
                    || (chars.length == 1 && character == '-')) // или одиночный '-'
            {
                return false;
            }
        }
        return true;
    }
}
