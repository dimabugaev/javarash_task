package com.javarush.task.task27.task2712.kitchen;

public enum Dish {
    FISH(25),
    STEAK(30),
    SOUP(15),
    JUICE(5),
    WATER(3);

    private int duration;

    Dish(int duration) {
        this.duration = duration;
    }

    public static String allDishesToString(){
        StringBuilder stringBuilder = new StringBuilder();
        for (Dish dish : Dish.values()){
            if (stringBuilder.length() > 0)
                stringBuilder.append(", ");
            stringBuilder.append(dish);
        }
        return stringBuilder.toString();
    }

    public int getDuration() {
        return duration;
    }
}
