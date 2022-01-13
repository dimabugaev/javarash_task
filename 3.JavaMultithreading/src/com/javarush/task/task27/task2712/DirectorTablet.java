package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.text.SimpleDateFormat;
import java.util.*;

public class DirectorTablet {
    public static void main(String[] args) {

    }

    public void printAdvertisementProfit(){
        Map<Date, Double> report = StatisticManager.getInstance().reportAdvertisementProfit();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        double total = 0;

        Date[] dateSet = new Date[report.size()];
        report.keySet().toArray(dateSet);
        Arrays.sort(dateSet);
        //for (Iterator<Date> it = dateSet.descendingIterator(); it.hasNext(); ) {
        for (int i = dateSet.length - 1; i >= 0; i--) {
            double valueReport = report.get(dateSet[i]).doubleValue();
            total += valueReport;
            ConsoleHelper.writeMessage(String.format("%s - %.2f", simpleDateFormat.format(dateSet[i]), valueReport));
        }

        ConsoleHelper.writeMessage(String.format("Total - %.2f", total));
    }
    public void printCookWorkloading(){

        Map<Date, Map<String, Integer>> report = StatisticManager.getInstance().reportCooked();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        Date[] dateSet = new Date[report.size()];
        report.keySet().toArray(dateSet);
        Arrays.sort(dateSet);
        for (int i = dateSet.length - 1; i >= 0; i--) {
            ConsoleHelper.writeMessage(simpleDateFormat.format(dateSet[i]));

            Map<String, Integer> daylyReport = report.get(dateSet[i]);

            List<Map.Entry<String, Integer>> list = new ArrayList(daylyReport.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return o2.getValue() - o1.getValue();
                }
            });

            for (Map.Entry<String, Integer> unit: list){
                //ConsoleHelper.writeMessage(String.format("%s - %d min", unit.getKey(), (int)Math.ceil((double)unit.getValue()/60)));
                ConsoleHelper.writeMessage(String.format("%s - %d min", unit.getKey(), unit.getValue()));
            }
        }

    }
    public void printActiveVideoSet(){

        List<Advertisement> listActive = StatisticAdvertisementManager.getInstance().getActiveAdv();

        Collections.sort(listActive, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                String first = o1.getName();
                String second = o2.getName();


                String firstControl = o1.getName().replaceAll("[А-Яа-яЁё]", "");
                String secondControl = o2.getName().replaceAll("[А-Яа-яЁё]", "");

                boolean russian1 = (first.length() != firstControl.length());
                boolean russian2 = (second.length() != secondControl.length());

                boolean compare = (russian1 == russian2);

                if (compare) return o1.getName().compareToIgnoreCase(o2.getName());
                else{
                    if (russian2) return -1;
                    else return 1;
                }
            }
        });

        for (Advertisement video: listActive){
            ConsoleHelper.writeMessage(String.format("%s - %d",video.getName(),video.getHits()));
        }

    }
    public void printArchivedVideoSet(){
        List<Advertisement> listArchive = StatisticAdvertisementManager.getInstance().getArchiveAdv();
        Collections.sort(listArchive, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                String first = o1.getName();
                String second = o2.getName();


                String firstControl = o1.getName().replaceAll("[А-Яа-яЁё]", "");
                String secondControl = o2.getName().replaceAll("[А-Яа-яЁё]", "");

                boolean russian1 = (first.length() != firstControl.length());
                boolean russian2 = (second.length() != secondControl.length());

                boolean compare = (russian1 == russian2);

                if (compare) return o1.getName().compareToIgnoreCase(o2.getName());
                else{
                    if (russian2) return -1;
                    else return 1;
                }
            }
        });

        for (Advertisement video: listArchive){
            ConsoleHelper.writeMessage(String.format("%s",video.getName()));
        }
    }
}
