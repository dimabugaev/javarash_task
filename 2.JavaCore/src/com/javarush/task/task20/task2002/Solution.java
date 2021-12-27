package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/

public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            //File yourFile = File.createTempFile("your_file_name", null);
            String yourFile = "/Users/dmitrybugaev/Documents/res1.txt";
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут

            User us = new User();
            us.setFirstName("Vasya");
            us.setLastName("Oblom");
            us.setBirthDate(new Date());
            us.setMale(true);
            us.setCountry(User.Country.RUSSIA);
            javaRush.users.add(us);

            User us2 = new User();
            us2.setFirstName("Vasya2");
            us2.setLastName("Oblom2");
            us2.setBirthDate(new Date());
            us2.setMale(true);
            us2.setCountry(User.Country.UKRAINE);
            javaRush.users.add(us2);


            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter writer = new PrintWriter(outputStream);
            writer.println(users.size());
            for(User unit: users){
                writer.println(unit.getFirstName());
                writer.println(unit.getLastName());
                writer.println(unit.getBirthDate().getTime());
                if (unit.isMale()) writer.println("yes");
                else writer.println("no");
                writer.println(unit.getCountry().getDisplayName());
            }
            writer.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            int countUser = Integer.parseInt(reader.readLine());
            for (int i = 0; i < countUser; i++) {
                User us = new User();
                us.setFirstName(reader.readLine());
                us.setLastName(reader.readLine());
                us.setBirthDate(new Date(Long.parseLong(reader.readLine())));
                if ("yes".equals(reader.readLine())) us.setMale(true);
                else us.setMale(false);
                us.setCountry(User.Country.fromString(reader.readLine()));

                users.add(us);
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
