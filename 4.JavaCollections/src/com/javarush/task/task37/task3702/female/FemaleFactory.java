package com.javarush.task.task37.task3702.female;

import com.javarush.task.task37.task3702.AbstractFactory;
import com.javarush.task.task37.task3702.Human;

public class FemaleFactory implements AbstractFactory {

    @Override
    public Human getPerson(int age){
        Human human = null;
        if (KidGirl.MAX_AGE >= age && age > 0)
            human = new KidGirl();
        else if (KidGirl.MAX_AGE < age && TeenGirl.MAX_AGE >= age)
            human = new TeenGirl();
        else if (TeenGirl.MAX_AGE < age)
            human = new Woman();

        return human;
    }
}
