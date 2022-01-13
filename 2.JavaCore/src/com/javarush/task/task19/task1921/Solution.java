package com.javarush.task.task19.task1921;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {

        if (args.length > 0){
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            //new BufferedReader(new InputStreamReader(new ))
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy");
            while (reader.ready()){
                String[] line = reader.readLine().trim().split(" ");
                String name = "";
                String date = "";
                for (int i = 0; i < line.length; i++) {
                    if ("".equals(line[i].replaceAll("\\D", "")))
                        name = name + line[i] + " ";
                    else
                        date = date + line[i] + " ";
                }
                PEOPLE.add(new Person(name.trim(), dateFormat.parse(date.trim())));
            }
            reader.close();
        }
    }
}
