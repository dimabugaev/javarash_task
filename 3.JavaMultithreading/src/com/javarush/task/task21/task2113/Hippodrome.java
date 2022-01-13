package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {

    private List<Horse> horses;

    public static Hippodrome game;

    public static void main(String[] args) throws InterruptedException {
        List<Horse> horses = new ArrayList<>();
        horses.add(new Horse("Kon-Ogon", 3, 0));
        horses.add(new Horse("Kon-Gorbun", 3, 0));
        horses.add(new Horse("Angella", 3, 0));

        game = new Hippodrome(horses);

        game.run();
        game.printWinner();
    }

    public Horse getWinner(){
        Horse maxHorse = null;

        if (horses.size()>0) {
            maxHorse = horses.get(0);
            for (Horse horse : this.horses) {
                if (horse.getDistance() > maxHorse.getDistance())
                    maxHorse = horse;
            }
        }
        return maxHorse;
    }

    public void printWinner(){
        System.out.printf("Winner is %s!\n", getWinner().getName());
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move(){
        for(Horse horse : this.horses){
            horse.move();
        }
    }

    public void print(){
        for(Horse horse : this.horses){
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Hippodrome(List<Horse> horses){
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }
}
