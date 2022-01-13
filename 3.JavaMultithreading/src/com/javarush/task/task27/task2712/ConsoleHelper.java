package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString() throws IOException {
        //try {
            return bufferedReader.readLine();
//        } catch (IOException e) {
//            return null;
//        }
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> result = new ArrayList<>();
        while (true) {
            writeMessage("Выберите блюдо: " + Dish.allDishesToString());
            String inputString = readString();
            if ("exit".equals(inputString)) break;

            try {
                result.add(Dish.valueOf(inputString));
            }catch (IllegalArgumentException e){
                writeMessage("блюдо отсутствует в меню");
            }
        }
        return result;
    }
}
