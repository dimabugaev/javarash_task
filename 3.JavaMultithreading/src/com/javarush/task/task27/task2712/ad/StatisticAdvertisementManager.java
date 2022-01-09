package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

public class StatisticAdvertisementManager {
    private static final StatisticAdvertisementManager instance = new StatisticAdvertisementManager();
    private final AdvertisementStorage advertisementStorage = AdvertisementStorage.getInstance();

    private StatisticAdvertisementManager(){
    }

    public static StatisticAdvertisementManager getInstance() {
        return instance;
    }

    public List<Advertisement> getActiveAdv()
    {
        List<Advertisement> res = new ArrayList<>();

        for(Advertisement adv: advertisementStorage.list()){
            if (adv.getHits() > 0)
                res.add(adv);

        }
        return res;
    }

    public List<Advertisement> getArchiveAdv()
    {
        List<Advertisement> res = new ArrayList<>();

        for(Advertisement adv: advertisementStorage.list()){
            if (adv.getHits() == 0)
                res.add(adv);
        }
        return res;
    }


}
