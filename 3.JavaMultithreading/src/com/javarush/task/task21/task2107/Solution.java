package com.javarush.task.task21.task2107;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* 
Глубокое клонирование карты
*/

public class Solution implements Cloneable{

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

            System.out.println(solution.users.equals(clone.users));

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }


    protected Map<String, User> users = new LinkedHashMap();

    @Override
    protected Solution clone() throws CloneNotSupportedException {
        Solution clone = (Solution) super.clone();
        clone.users = new LinkedHashMap<>();
        clone.users.putAll(this.users);

        for (Map.Entry<String, User> value: clone.users.entrySet()){
            value.setValue(value.getValue().clone());
        }

        return clone;
    }

    public static class User implements Cloneable{
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        protected User clone() throws CloneNotSupportedException {
            return (User) super.clone();
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof User)) return false;

            User us = (User) obj;
            if (age != us.age) return false;

            if (name != null ? !name.equals(us.name) : us.name != null) return false;

            return true;
        }
    }
}
