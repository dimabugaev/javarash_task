package com.javarush.task.task18.task1828;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Прайсы 2
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();

        if (args.length > 0)
        {

            String toWrite = "";

            if (args.length == 5 && args[0].equals("-u"))
                toWrite = String.format("%-8.8s", args[1]) + String.format("%-30.30s", args[2])
                    + String.format("%-8.8s", args[3]) + String.format("%-4.4s", args[4]);
            else if (args.length == 2 && args[0].equals("-d"))
                toWrite = "";
            else
                throw new IOException();


            ArrayList<String> newdata = getListoffSt(fileName, Integer.parseInt(args[1].trim()), toWrite);

            FileWriter writer = new FileWriter(fileName);
            for (String line: newdata){
                writer.write(line);
            }
            writer.close();

        }
    }

    public static ArrayList<String> getListoffSt(String fileName, int seekid, String update) throws IOException {
        int lehgth = 50;

        ArrayList<String> datafile = new ArrayList<>();

        FileReader reader = null;

        try {
            char[] buf = new char[lehgth];
            reader = new FileReader(fileName);
            while (reader.read(buf,0, lehgth) != -1){
                int id = Integer.parseInt(String.valueOf(Arrays.copyOf(buf,8)).replaceAll(" ",""));
                if (id == seekid){
                    datafile.add(update);
                }else
                {
                    datafile.add(String.valueOf(buf));
                }

                if (reader.read() > 0) {
                    if (!(id == seekid && update.isEmpty()))
                        datafile.add("\n");
                }
                else{
                    break;
                }
            }
        } catch (Exception e) {

        }finally {
            if (reader != null)
                reader.close();
        }


        return datafile;
    }
}
