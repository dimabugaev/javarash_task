package com.javarush.task.task37.task3702.male;

import com.javarush.task.task37.task3702.AbstractFactory;
import com.javarush.task.task37.task3702.Human;

public class MaleFactory implements AbstractFactory {

    @Override
    public Human getPerson(int age){
        Human human = null;
        if (KidBoy.MAX_AGE >= age && age > 0)
            human = new KidBoy();
        else if (KidBoy.MAX_AGE < age && TeenBoy.MAX_AGE >= age)
            human = new TeenBoy();
        else if (TeenBoy.MAX_AGE < age)
            human = new Man();

        return human;
    }
}
