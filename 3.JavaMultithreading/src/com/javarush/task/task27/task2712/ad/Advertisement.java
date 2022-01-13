package com.javarush.task.task27.task2712.ad;

public class Advertisement implements Comparable{
    private Object content;
    private String name;
    private long initialAmount;
    private int hits;
    private int duration;
    private long amountPerOneDisplaying;

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;

        if (hits !=0)
            this.amountPerOneDisplaying = initialAmount/hits;
        else
            this.amountPerOneDisplaying = 0;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public long getThousendAmount(){
        return this.amountPerOneDisplaying*1000/this.duration;
    }

    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }

    public int getHits() {
        return hits;
    }

    public void revalidate(){
        if (hits <= 0)
            throw new UnsupportedOperationException();
        else
            hits--;
    }

    @Override
    public int compareTo(Object o) {
        Advertisement obj = (Advertisement) o;
        if (this.amountPerOneDisplaying != obj.getAmountPerOneDisplaying())
            return (int) (obj.getAmountPerOneDisplaying() - this.amountPerOneDisplaying);
        long thisCostThousend = this.amountPerOneDisplaying*1000/this.duration;
        long objCostThousend = obj.amountPerOneDisplaying*1000/obj.duration;
        return (int)(thisCostThousend - objCostThousend);
    }

}
