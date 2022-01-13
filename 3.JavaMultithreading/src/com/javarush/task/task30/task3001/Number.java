package com.javarush.task.task30.task3001;

public class Number {
    private NumberSystem numberSystem;
    private String digit;

    public Number(NumberSystem numberSystem, String digit) {
        this.numberSystem = numberSystem;
        this.digit = digit;
    }

    public NumberSystem getNumberSystem() {
        return numberSystem;
    }

    public String getDigit() {
        return digit;
    }

    void checkCorrect() throws NumberFormatException{

        String pathReg = "";
        if (numberSystem.getNumberSystemIntValue() <= 10)
            pathReg = String.valueOf(numberSystem.getNumberSystemIntValue() - 1);
        else if (numberSystem.getNumberSystemIntValue() == 12){
            pathReg = "9ABab";
        }else
            pathReg = "9ABCDEFabcdef";

        String reg = "[0-" + pathReg + "]+";

        if (!digit.matches(reg))
            throw new NumberFormatException();
    }

    @Override
    public String toString() {
        return "Number{" +
                "numberSystem=" + numberSystem +
                ", digit='" + digit + '\'' +
                '}';
    }
}
