package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        initDishes();
    }

    protected void initDishes() throws IOException {
        dishes = ConsoleHelper.getAllDishesForOrder();
    }

    public int getTotalCookingTime(){
        int sum = 0;
        for (Dish dish:dishes){
            sum += dish.getDuration();
        }
        return sum;
    }

    private String getStringDishes(){
        StringBuilder stringBuilder = new StringBuilder();
        for (Dish dish: dishes){
            if (stringBuilder.length() > 0)
                stringBuilder.append(", ");
            stringBuilder.append(dish);
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        if (dishes.size() > 0)
            return String.format("Your order: [%s] of %s, cooking time %dmin", getStringDishes(), tablet.toString(), getTotalCookingTime());
        else
            return "";
    }

    public boolean isEmpty(){
        return dishes.isEmpty();
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public Tablet getTablet() {
        return tablet;
    }
}
