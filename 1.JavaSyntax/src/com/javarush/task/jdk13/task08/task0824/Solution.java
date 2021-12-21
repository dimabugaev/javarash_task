package com.javarush.task.jdk13.task08.task0824;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* 
Вся семья в сборе
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        ArrayList<Human> list = new ArrayList<>();

        Human child1 = new Human("Vasya", true,12);
        list.add(child1);
        Human child2 = new Human("Petya", true,15);
        list.add(child2);
        Human child3 = new Human("Masha", false,10);
        list.add(child3);

        Human father = new Human("Vova", true,40, new Human[]{child1, child2, child3});
        list.add(father);

        Human mother = new Human("Katya", false,35, new Human[]{child1, child2, child3});
        list.add(mother);

        Human ded1 = new Human("GrandPA", true,70, new Human[]{father});
        list.add(ded1);
        Human baba1 = new Human("GrandMA", false,72, new Human[]{father});
        list.add(baba1);

        Human ded2 = new Human("GrandPA2", true,80, new Human[]{mother});
        list.add(ded2);
        Human baba2 = new Human("GrandMA2", false,92, new Human[]{mother});
        list.add(baba2);

        for (Human man: list){
            System.out.println(man.toString());
        }

    }

    public static class Human {
        //напишите тут ваш код
        public String name;
        public boolean sex;
        public int age;
        public ArrayList<Human> children;

        public Human(String name, boolean sex, int age){
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.children = new ArrayList<>();
        }

        public Human(String name, boolean sex, int age, Human[] children){
            this.name = name;
            this.age = age;
            this.sex = sex;

            this.children = new ArrayList<>();
            this.children.addAll(Arrays.asList(children));
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }
}
