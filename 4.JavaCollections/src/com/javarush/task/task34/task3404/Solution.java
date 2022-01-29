package com.javarush.task.task34.task3404;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Рекурсия для мат. выражения
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.recurse("sin(2*(-5+1.5*4)+28)", 0); // Expected output: 0.5 6
        System.out.println("0.5 6 - expected output");

        solution.recurse("tan(45)", 0);  System.out.println("1 1 - expected output");
        solution.recurse("tan(-45)", 0);  System.out.println("-1 2 - expected output");
        solution.recurse("0.305", 0);  System.out.println("0.3 0 - expected output");
        solution.recurse("0.3051", 0);  System.out.println("0.31 - expected output");
        solution.recurse("(0.3051)", 0);  System.out.println("0.31 - expected output");
        solution.recurse("1+(1+(1+1)*(1+1))*(1+1)+1", 0);  System.out.println("12 8 - expected output");
        solution.recurse("tan(44+sin(89-cos(180)^2))", 0);  System.out.println("1 6 - expected output");
        solution.recurse("-2+(-2+(-2)-2*(2+2))", 0);  System.out.println("-14 8 - expected output");
        solution.recurse("sin(80+(2+(1+1))*(1+1)+2)", 0);  System.out.println("1 7 - expected output");
        solution.recurse("1+4/2/2+2^2+2*2-2^(2-1+1)", 0);  System.out.println("6 11 - expected output");
        solution.recurse("10-2^(2-1+1)", 0);  System.out.println("6 4 - expected output");
        solution.recurse("2^10+2^(5+5)", 0);  System.out.println("2048 4 - expected output");
        solution.recurse("1.01+(2.02-1+1/0.5*1.02)/0.1+0.25+41.1", 0);  System.out.println("72.96 8 - expected output");
        solution.recurse("0.000025+0.000012", 0);  System.out.println("0 1 - expected output");
        solution.recurse("-2-(-2-1-(-2)-(-2)-(-2-2-(-2)-2)-2-2)", 0);  System.out.println("-3 16 - expected output");
        solution.recurse("cos(3 + 19*3)", 0);  System.out.println("0.5 3 - expected output");
        solution.recurse("(-1 + (-2))", 0);  System.out.println("-3 3 - expected output");
        solution.recurse("-sin(2*(-5+1.5*4)+28)", 0);  System.out.println("-0.5 7 - expected output");
        solution.recurse("sin(100)-sin(100)", 0);  System.out.println("0 3 - expected output");
        solution.recurse("-(-22+22*2)", 0);  System.out.println("-22 4 - expected output");
        solution.recurse("-2^(-2)", 0);  System.out.println("-0.25 3 - expected output");
        solution.recurse("-(-2^(-2))+2+(-(-2^(-2)))", 0);  System.out.println("2.5 10 - expected output");
        solution.recurse("(-2)*(-2)", 0);  System.out.println("4 3 - expected output");
        solution.recurse("(-2)/(-2)", 0);  System.out.println("1 3 - expected output");
        solution.recurse("sin(-30)", 0);  System.out.println("-0.5 2 - expected output");
        solution.recurse("cos(-30)", 0);  System.out.println("0.87 2 - expected output");
        solution.recurse("tan(-30)", 0);  System.out.println("-0.58 2 - expected output");
        solution.recurse("2+8*(9/4-1.5)^(1+1)", 0);  System.out.println("6.5 6 - expected output");
        solution.recurse("0.005", 0);  System.out.println("0.01 0 - expected output");
        solution.recurse("0.0049", 0);  System.out.println("0 0 - expected output");
        solution.recurse("0+0.304", 0);  System.out.println("0.3 1 - expected output");
        solution.recurse("sin(45) - cos(45)", 0);  System.out.println("0 3 - expected output");
        solution.recurse("0/(-3)", 0);  System.out.println("0 2 - expected output");
    }

    public void recurse(final String expression, int countOperation) {
        //implement
        int[] count = new int[1];

        if (!expression.matches("-?\\d*\\.?\\d+")){
            String result = trueRecurse(expression.replaceAll(" ",""), count);
            recurse(result, count[0]);
        }else {
            DecimalFormat df = new DecimalFormat("#.##");
            DecimalFormatSymbols dfs = df.getDecimalFormatSymbols();
            dfs.setDecimalSeparator('.');
            df.setDecimalFormatSymbols(dfs);
            String res = df.format(Double.parseDouble(expression));
            System.out.println(String.format("%s %d", res, countOperation));
        }
    }

    public String trueRecurse(String expression, int[] countOperation){

        Pattern pattern = Pattern.compile("((sin|cos|tan)-?\\d*\\.?\\d+)|(\\([^()cst]+\\))");

        while (!expression.matches("-?\\d*\\.?\\d+")){
            Matcher matcher = pattern.matcher(expression);
            if (matcher.find()) {
                //System.out.println(matcher.group());
                String head = expression.substring(0, matcher.start());
                String tail = expression.substring(matcher.end(), expression.length());
                expression = head + execString(matcher.group(), countOperation) + tail;

                if (expression.matches("-?\\d*\\.?\\d+") && head.equals("-"))
                    countOperation[0]++;

                //expression = expression.replaceAll("^--","");

            }else if (!expression.matches("-?\\d*\\.?\\d+")){
                expression = "(" + expression + ")";
            }
        }
        DecimalFormat df = new DecimalFormat("#.##");
        DecimalFormatSymbols dfs = df.getDecimalFormatSymbols();
        dfs.setDecimalSeparator('.');
        df.setDecimalFormatSymbols(dfs);
        expression = df.format(Double.parseDouble(expression));

        return expression;
    }

    private String execString(String expression, int[] countOperation){

        int pos = 0;
        Stack<String> numberStack = new Stack<>();
        Stack<Leksema> operationStack = new Stack<>();

        // -sin(2) + 5 - 10 * 24
        boolean readedOperator = false;
        boolean readedNumber = false;

        expression = expression.replaceAll("[()]", "");
        if (expression.matches("-?\\d*\\.?\\d+")) {
            if (expression.charAt(pos) == '-') countOperation[0]++;
            return expression;
        }

        if (!expression.isEmpty()) {
            if (expression.charAt(pos) == '-') countOperation[0]++;
            if (expression.charAt(pos) == 's' || expression.charAt(pos) == 'c'
                    || expression.charAt(pos) == 't') {
                readedOperator = false;
                readedNumber = true;
            } else {
                readedOperator = true;
                readedNumber = false;
            }
        }

        while (pos < expression.length()){


            if (readedNumber){
                Leksema operation = Leksema.fromString(String.valueOf(expression.charAt(pos)));

                while (!operationStack.empty() && operationStack.peek().getPrioritet() <= operation.getPrioritet()){
                    execNext(numberStack, operationStack);
                    countOperation[0]++;
                }

                operationStack.push(operation);
                if (operation == Leksema.COS || operation == Leksema.SIN || operation == Leksema.TAN)
                    pos += 3;
                else
                    pos ++;

                readedNumber = false;
                readedOperator = true;
                continue;
            }

            if (readedOperator){
                StringBuilder number = new StringBuilder();
                if (!((expression.charAt(pos) >= '0' && expression.charAt(pos) <= '9') ||
                        expression.charAt(pos) == '.' || (expression.charAt(pos) == '-' && number.length()==0)))
                    throw new RuntimeException("wrong simbols " + expression.charAt(pos));

                while (expression.charAt(pos) >= '0' && expression.charAt(pos) <= '9' ||
                        expression.charAt(pos) == '.' || (expression.charAt(pos) == '-' && number.length()==0)){

                    if (expression.charAt(pos) == '-' && expression.charAt(pos+1) == '-'){
                        pos+=2;
                        //countOperation[0]++;
                        continue;
                    }
                    number.append(expression.charAt(pos));
//                    if (expression.charAt(pos) == '-' )
//                        countOperation[0]++;
                    pos++;
                    if (pos >= expression.length())
                        break;
                }
                if (number.length() > 0)
                    numberStack.push(number.toString());

                readedNumber = true;
                readedOperator = false;
                //continue;
            }

//            try{
////                if (expression.charAt(pos) == '(' || expression.charAt(pos) == ')') {
////                    pos++;
////                    continue;
////                }
//                Leksema operation = Leksema.fromString(String.valueOf(expression.charAt(pos)));
//
//                while (!operationStack.empty() && operationStack.peek().getPrioritet() < operation.getPrioritet()){
//                    execNext(numberStack, operationStack);
//                    countOperation++;
//                }
//
//                operationStack.push(operation);
//                if (operation == Leksema.COS || operation == Leksema.SIN || operation == Leksema.TAN)
//                    pos += 3;
//                else
//                    pos ++;
//            } catch (IllegalArgumentException e) {
//                StringBuilder number = new StringBuilder();
//                if (!((expression.charAt(pos) >= '0' && expression.charAt(pos) <= '9') ||
//                        expression.charAt(pos) == '.' || expression.charAt(pos) == '-' ))
//                    throw new RuntimeException("wrong simbols " + expression.charAt(pos));
//
//                while (expression.charAt(pos) >= '0' && expression.charAt(pos) <= '9' || expression.charAt(pos) == '.'){
//                    number.append(expression.charAt(pos));
//                    pos++;
//                }
//                if (number.length() > 0)
//                    numberStack.push(number.toString());
//            }
        }

        while (numberStack.size() > 1 || !operationStack.empty()){
            execNext(numberStack, operationStack);
            countOperation[0]++;
        }

        DecimalFormat df = new DecimalFormat("#.##");
        DecimalFormatSymbols dfs = df.getDecimalFormatSymbols();
        dfs.setDecimalSeparator('.');
        df.setDecimalFormatSymbols(dfs);
        numberStack.push(df.format(Double.parseDouble(numberStack.pop())));

        return numberStack.pop();
    }



    private void execNext(Stack<String> numberStack, Stack<Leksema> operationsStack){
//        if (operation.getPrioritet() == 1 && second != null)
//            throw new RuntimeException("wrong operations " + operation.name + " must have only one argument");
//        else if (operation.getPrioritet() > 1 && second == null)
//            throw new RuntimeException("wrong operations " + operation.name + " must have two arguments");

        String first = numberStack.pop();
        Leksema operation = operationsStack.pop();
        String second = null;
        if (operation.getPrioritet() > 1){
            if (!numberStack.isEmpty())
                second = numberStack.pop();
        }


        double result = 0;
        double a = Double.parseDouble(first);
        double b = 0;
        if (second != null)
            b = Double.parseDouble(second);

        switch (operation){
            case PLUS:
                result = a + b;
                break;
            case MINUS:
//                if (second == null)
//                    result = -1.0 * a;
//                else
                result = b - a;
                break;
            case DIV:
                result = b / a;
                break;
            case MULT:
                result = a * b;
                break;
            case POV:
                result = Math.pow(b, a);
                if (b < 0) result *= -1;
                break;
            case SIN:
                result = Math.sin(Math.toRadians(a));
                break;
            case COS:
                result = Math.cos(Math.toRadians(a));
                break;
            case TAN:
                result = Math.tan(Math.toRadians(a));
                break;
            case NUMBERS:
                break;
        }

        //if (result != 0){
//            DecimalFormat df = new DecimalFormat("#.##");
//            DecimalFormatSymbols dfs = df.getDecimalFormatSymbols();
//            dfs.setDecimalSeparator('.');
//            df.setDecimalFormatSymbols(dfs);
//            numberStack.push(df.format(result));
        //}
        if (result == -0.0) result = 0.0;

        numberStack.push(String.valueOf(result));

    }

    enum Leksema{
        PLUS(4, "+"),
        MINUS(4, "-"),
        DIV(3, "/"),
        MULT(3,"*"),
        POV(2, "^"),
        SIN(1, "s"),
        COS(1, "c"),
        TAN(1, "t"),
        NUMBERS(0, "[0-9]");

        private int prioritet;
        private String name;

        Leksema(int prioritet, String name) {
            this.prioritet = prioritet;
            this.name = name;
        }

        public int getPrioritet() {
            return prioritet;
        }

        public String getName() {
            return name;
        }

        public static Leksema fromString(String text) {
            for (Leksema b : Leksema.values()) {
                if (b.name.equalsIgnoreCase(text)) {
                    return b;
                }
            }
            throw new IllegalArgumentException();
            //return null;
        }
    }

    public Solution() {
        //don't delete
    }
}
