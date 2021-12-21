package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileNameAll = reader.readLine();
        String fileNameForRemove = reader.readLine();
        reader.close();


        BufferedReader fileAll = new BufferedReader(new FileReader(fileNameAll));
        while (true){
            String line = fileAll.readLine();
            if (line == null) break;
            allLines.add(line);
        }
        fileAll.close();

        BufferedReader fileRemove = new BufferedReader(new FileReader(fileNameForRemove));
        while (true){
            String line = fileRemove.readLine();
            if (line == null) break;
            forRemoveLines.add(line);
        }
        fileRemove.close();

        Solution getJoin = new Solution();
        getJoin.joinData();

    }

    public void joinData() throws CorruptedDataException {
        try {
            for (String line : forRemoveLines){
                if (!allLines.remove(line))
                    throw new CorruptedDataException();
            }
        }catch (CorruptedDataException e){
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
