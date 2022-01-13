package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.*;

public class StatisticManager {

    private static final StatisticManager instance = new StatisticManager();

    private StatisticStorage statisticStorage = new StatisticStorage();
    //private Set<Cook> cooks = new HashSet<>();

//    public Set<Cook> getCooks() {
//        return cooks;
//    }

    private StatisticManager(){
       //this.statisticStorage = new StatisticStorage();
    }

    public static StatisticManager getInstance() {
        return instance;
    }

    public void register(EventDataRow data){
        statisticStorage.put(data);
    }

//    public void register(Cook cook){
//        cooks.add(cook);
//    }

    public Map<Date, Double> reportAdvertisementProfit(){
        List<EventDataRow> reportData = statisticStorage.get(EventType.SELECTED_VIDEOS);
        Map<Date, Double> groupReportData = new HashMap<>();

        for (EventDataRow reportString: reportData){
            Date dateReport = getStartOfDay(reportString.getDate());

            double sumReport = 0;
            if (groupReportData.containsKey(dateReport))
                sumReport = groupReportData.get(dateReport);
            sumReport += ((double) ((VideoSelectedEventDataRow) reportString).getAmount())/100;
            groupReportData.put(dateReport, sumReport);
        }
        return groupReportData;
    }

    public Map<Date, Map<String, Integer>> reportCooked(){
        List<EventDataRow> reportData = statisticStorage.get(EventType.COOKED_ORDER);
        Map<Date, Map<String, Integer>> groupReportData = new HashMap<>();

        for (EventDataRow reportString: reportData){
            Date dateReport = getStartOfDay(reportString.getDate());
            Map<String, Integer> daylyReport;

            if (groupReportData.containsKey(dateReport))
                daylyReport = groupReportData.get(dateReport);
            else {
                daylyReport = new HashMap<>();
                groupReportData.put(dateReport, daylyReport);
            }
            String cookNameReport = ((CookedOrderEventDataRow)reportString).getCookName();

            int sumReport = 0;
            if (daylyReport.containsKey(cookNameReport))
                sumReport = daylyReport.get(cookNameReport);

            sumReport += reportString.getTime();
            daylyReport.put(cookNameReport, sumReport);
        }
        return groupReportData;
    }

    private Date getStartOfDay(Date date){
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    private class StatisticStorage{

        Map<EventType, List<EventDataRow>> storage = new HashMap<>();

        public StatisticStorage() {
            for (EventType eventType: EventType.values()){
                storage.put(eventType, new ArrayList<EventDataRow>());
            }
        }

        private List<EventDataRow> get(EventType eventType){
            return storage.get(eventType);
        }

        private void put(EventDataRow data){
            storage.get(data.getType()).add(data);
        }
    }


}
