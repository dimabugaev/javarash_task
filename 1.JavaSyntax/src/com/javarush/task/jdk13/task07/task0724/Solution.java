package com.javarush.task.jdk13.task07.task0724;

/* 
Семья
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        ArrayList<Human> list = new ArrayList<>();

        Human grandfather1 = new Human("BigGrandPa", true, 110);
        list.add(grandfather1);
        Human grandmother1 = new Human("BigGrandMA", false, 101);
        list.add(grandmother1);

        Human grandfather2 = new Human("GrandPa", true, 99);
        list.add(grandfather2);
        Human grandmother2 = new Human("GrandMA", false, 90);
        list.add(grandmother2);

        Human father = new Human("Папа Саша", true, 50, grandfather1, grandmother1);
        list.add(father);
        Human mother = new Human("Мама Валя", false, 45, grandfather2, grandmother2);
        list.add(mother);

        Human son1 = new Human("Сынок", true, 25, father, mother);
        list.add(son1);
        Human son2 = new Human("Сынок2", true, 20, father, mother);
        list.add(son2);
        Human doter1 = new Human("Доча", false, 17, father, mother);
        list.add(doter1);

        for (Human man : list)
            System.out.println(man.toString());

    }

    public static class Human {
        // напишите тут ваш код
        private String name;
        private boolean sex;
        private int age;
        private Human father;
        private Human mother;

        public Human(String name, boolean sex, int age){
            this.age = age;
            this.sex = sex;
            this.name = name;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother){
            this.age = age;
            this.sex = sex;
            this.name = name;

            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null) {
                text += ", отец: " + this.father.name;
            }

            if (this.mother != null) {
                text += ", мать: " + this.mother.name;
            }

            return text;
        }
    }
}