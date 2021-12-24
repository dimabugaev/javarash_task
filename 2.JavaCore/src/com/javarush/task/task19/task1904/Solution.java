package com.javarush.task.task19.task1904;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        PersonScannerAdapter personScannerAdapter = new PersonScannerAdapter(new Scanner(new FileReader(args[0])));

        personScannerAdapter.read();
        personScannerAdapter.close();
    }

    public static class PersonScannerAdapter implements PersonScanner{
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner){
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {

            String lastName = fileScanner.next();
            String firstName = fileScanner.next();
            String middleName = fileScanner.next();
            String stDate = fileScanner.next() + "." + fileScanner.next() + "." + fileScanner.next();
            SimpleDateFormat formatDate = new SimpleDateFormat("dd.MM.yyyy");
            Date birthDate = new Date();
            try {
                birthDate = formatDate.parse(stDate);
            }catch (ParseException e){}

            return new Person(firstName, middleName, lastName, birthDate);
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
