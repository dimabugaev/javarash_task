package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        if (args.length > 0){
            switch (args[0]){
                case "-c":{
                    synchronized (allPeople) {
                        if ((args.length - 1) % 3 == 0)
                            for (int i = 1; i < args.length; i += 3) {
                                addPeople(args[i], args[i + 1], args[i + 2]);
                            }
                        break;
                    }
                }
                case "-i":{
                    synchronized (allPeople) {
                        if (args.length >= 2)
                            for (int i = 1; i < args.length; i++) {
                                getInfo(args[i]);
                            }
                        break;
                    }
                }
                case "-u":{
                    synchronized (allPeople) {
                        if ((args.length -1) % 4 == 0)
                            for (int i = 1; i < args.length; i+=4) {
                                updatePeople(args[i], args[i+1], args[i+2], args[i+3]);
                            }
                        break;
                    }
                }
                case "-d":{
                    synchronized (allPeople) {
                        if (args.length >= 2)
                            for (int i = 1; i < args.length; i++) {
                                deletePeople(args[i]);
                            }
                        break;
                    }
                }
            }
        }

    }

    public static void addPeople(String name, String sex, String birthday) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date newDate = format.parse(birthday);

        int male = 0;

        if (sex.equals("м"))
            male = 1;
        else if (sex.equals("ж"))
            male = 2;
        else
            throw new ParseException("sex uncorrected", 0);


        if (male == 1) {
            Person newPerson = Person.createMale(name, newDate);
            allPeople.add(newPerson);
            System.out.println(allPeople.lastIndexOf(newPerson));
        }
        if (male == 2) {
            Person newPerson = Person.createFemale(name, newDate);
            allPeople.add(newPerson);
            System.out.println(allPeople.lastIndexOf(newPerson));
        }



    }

    public static void getInfo(String index) throws ParseException{

        Person found = null;

        try {
            int i = Integer.parseInt(index);
            found = allPeople.get(i);
        }catch (Exception e){
            throw new ParseException("index uncorrected", 0);
        }

        if (found != null)
        {
            String printSex = "";
            if (found.getSex() == Sex.MALE)
                printSex = "м";
            else
                printSex = "ж";

            SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            System.out.println(found.getName() + " " + printSex + " " + format.format(found.getBirthDate()));
        }


    }

    public static void updatePeople(String index, String name, String sex, String birthday) throws ParseException{
        Person found = null;

        try {
            int i = Integer.parseInt(index);
            found = allPeople.get(i);
        }catch (Exception e){
            throw new ParseException("index uncorrected", 0);
        }

        if (found != null)
        {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Date newDate = format.parse(birthday);

            Sex newSex = null;

            if (sex.equals("м"))
                newSex = Sex.MALE;
            else if (sex.equals("ж"))
                newSex = Sex.FEMALE;
            else
                throw new ParseException("sex uncorrected", 0);

            found.setName(name);
            found.setSex(newSex);
            found.setBirthDate(newDate);
        }

    }

    public static void deletePeople(String index) throws ParseException{

        Person found = null;

        try {
            int i = Integer.parseInt(index);
            found = allPeople.get(i);
        }catch (Exception e){
            throw new ParseException("index uncorrected", 0);
        }

        if (found != null) {
            found.setName(null);
            found.setSex(null);
            found.setBirthDate(null);
        }
    }
}
