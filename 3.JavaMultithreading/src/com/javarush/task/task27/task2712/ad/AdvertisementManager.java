package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.NoAvailableVideoEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.*;

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos(){
        //ConsoleHelper.writeMessage("calling processVideos method");
        if (storage.list().size() == 0) {
            StatisticManager.getInstance().register(new NoAvailableVideoEventDataRow(timeSeconds));
            throw new NoVideoAvailableException();
        }

        List<Combo> result = new ArrayList<>();


        fillAllCombo(null, result, AdvertisementStorage.getInstance().list());

        Collections.sort(result);


        List<Advertisement> moveList = null;
        Combo selectedCombo = null;
        for (Combo unit: result){
            if (unit.sumDuration <= timeSeconds) {
                moveList = new ArrayList<>(unit);
                selectedCombo = unit;
                break;
            }
        }

        if (moveList == null) {
            StatisticManager.getInstance().register(new NoAvailableVideoEventDataRow(timeSeconds));
            throw new NoVideoAvailableException();
        }

        Collections.sort(moveList);

        StatisticManager.getInstance().register(new VideoSelectedEventDataRow(moveList, selectedCombo.sumAmount, (int) selectedCombo.sumDuration));

        for (Advertisement video: moveList){
            ConsoleHelper.writeMessage(String.format("%s is displaying... %d, %d", video.getName(), video.getAmountPerOneDisplaying(), video.getThousendAmount()));
            video.revalidate();
        }

    }

    private void fillAllCombo(Set<Advertisement> start, List<Combo> result, List<Advertisement> resurs) {
        if (start == null)
            start = new HashSet<>();
        for (int i = 0; i < resurs.size(); i++) {
            if (resurs.get(i).getHits() > 0) {
                if (!start.contains(resurs.get(i))) {
                    Set<Advertisement> mySet = new HashSet<>(start);
                    mySet.add(resurs.get(i));
                    Combo newCombo = new Combo(mySet);
                    if (newCombo.sumDuration <= timeSeconds) {
                        fillAllCombo(mySet, result, resurs);
                        result.add(newCombo);
                    }
                }
            }
        }
    }


    private static class Combo extends HashSet<Advertisement> implements Comparable{
        public final long sumAmount;
        public final long sumDuration;
        public final int count;

        public Combo(Set<Advertisement> c) {
            super(c);
            int sumAm = 0;
            int sumDur = 0;
            count = c.size();
            for (Advertisement unit: c){
                sumAm += unit.getAmountPerOneDisplaying();
                sumDur += unit.getDuration();
            }
            sumAmount = sumAm;
            sumDuration = sumDur;
        }

        @Override
        public int hashCode() {
            return (int) (sumDuration + sumAmount + count);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;

            if (!(o instanceof Combo)) return false;

            Combo obj = (Combo) o;

            if(this.size()>0)
                for (Advertisement unit: obj){
                    if (!this.contains(unit)) return false;
                }

            return this.count == obj.count && this.sumAmount == obj.sumAmount && this.sumDuration == obj.sumDuration;
        }

        @Override
        public int compareTo(Object o) {
            Combo obj = (Combo) o;
            if (this.sumAmount != obj.sumAmount)
                return (int)(obj.sumAmount - this.sumAmount);
            if (this.sumDuration != obj.sumDuration)
                return (int)(obj.sumDuration - this.sumDuration);
            if (this.count != obj.count)
                return  this.count - obj.count;

            return 0;
        }
    }
}
