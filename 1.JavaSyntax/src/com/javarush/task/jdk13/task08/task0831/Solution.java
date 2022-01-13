package com.javarush.task.jdk13.task08.task0831;

import java.util.Arrays;

/* 
Любимые настолки
*/

public class Solution {

    public static BoardGame[] collection = new BoardGame[5];

    public static void main(String[] args) {
        BoardGame chess = new BoardGame();
        chess.name = "Шахматы";
        collection[0] = chess;

        //напишите тут ваш код
        BoardGame nards = new BoardGame();
        nards.name = "Нарды";
        collection[1] = nards;

        BoardGame pref = new BoardGame();
        pref.name = "Преферанс";
        collection[2] = pref;

        BoardGame football = new BoardGame();
        football.name = "Футбол";
        collection[3] = football;

        BoardGame shash = new BoardGame();
        shash.name = "Шашки";
        collection[4] = shash;


        System.out.println(Arrays.toString(collection));
    }
}