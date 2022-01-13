package com.javarush.task.task19.task1916;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        String inputFileName1;
        String inputFileName2;


        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            inputFileName1 = reader.readLine();
            inputFileName2 = reader.readLine();
        }


        ArrayList<String> fileContent1 = new ArrayList<>();
        ArrayList<String> fileContent2 = new ArrayList<>();

        try (BufferedReader inputFileReader1 = new BufferedReader(new FileReader(inputFileName1))) {
            while (inputFileReader1.ready()) {
                fileContent1.add(inputFileReader1.readLine());
            }
        }

        try (BufferedReader inputFileReader2 = new BufferedReader(new FileReader(inputFileName2))) {
            while (inputFileReader2.ready()) {
                fileContent2.add(inputFileReader2.readLine());
            }
        }


        int posR = 0;
        int posL = 0;
        while (true){
            String left = getPosition(fileContent1, posL);
            String right = getPosition(fileContent2, posR);

            if (right == null && left == null) {
                break;
            }
            else if(left != null && right == null){
                lines.add(new LineItem(Type.REMOVED, left));
                posL++;
            }
            else if(left == null && right != null){
                lines.add(new LineItem(Type.ADDED, right));
                posR++;
            }
            else if(left.equals(right)){
                lines.add(new LineItem(Type.SAME, left));
                posL++;
                posR++;
            }
            else if(!left.equals(right)){
                String nextRight = getPosition(fileContent2, posR + 1);
                String nextLeft = getPosition(fileContent1, posL + 1);
                if(left.equals(nextRight)){
                    lines.add(new LineItem(Type.ADDED, right));
                    posR++;
                }
                else{
                    if(right.equals(nextLeft)) {
                        lines.add(new LineItem(Type.REMOVED, left));
                        posL++;
                    }else{
                        if (nextLeft != null) posL++;
                        else if (nextRight != null) posR++;
                        else {posL ++; posR++;}
                    }
                }
            }
        }


    }

    public static String getPosition(ArrayList<String> fileContent, int position){
        String result = null;
        try {
            result = fileContent.get(position);
        }catch (IndexOutOfBoundsException e){
            result = null;
        }
        return result;
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
