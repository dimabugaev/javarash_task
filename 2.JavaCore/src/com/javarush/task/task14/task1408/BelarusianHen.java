package com.javarush.task.task14.task1408;

public class BelarusianHen extends Hen {
    private static final int COUNT_EGGS = 55;
    private static final String COUNTRY = Country.BELARUS;

    @Override
    public int getCountOfEggsPerMonth() {
        return COUNT_EGGS;
    }

    String getDescription(){
        return super.getDescription() + " Моя страна - "+ COUNTRY +". Я несу "+COUNT_EGGS+" яиц в месяц.";
    }
}
