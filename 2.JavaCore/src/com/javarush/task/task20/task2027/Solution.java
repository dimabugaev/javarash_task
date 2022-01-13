package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/

public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        List<Word> res = detectAllWords(crossword, "home", "same");

        for (Word word : res){
            System.out.println(word);
        }
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {

        List<Word> list = new ArrayList<>();

        for (int i = 0; i < crossword.length; i++) {
            for (int j = 0; j < crossword[i].length; j++) {
                for(String text : words){
                    Words.getWordsAround(list, i, j, crossword, text);
                }
            }
        }

        return list;
    }

    public static class Words{

        public static void getWordsAround(List<Word> words, int x, int y, int[][] cross, String text){

            if (cross[x][y] != (int) text.charAt(0)) return;

            for(Go go : Go.values()){
                Word word = getWord(text, go, x, y, cross);
                if (word != null)
                    words.add(word);
            }

        }

        public static void addNext(Word word, Go go, int[][] cross){
            if (word == null) return;

            int newX;
            int newY;

            switch (go){
                case UP:{
                    newX = word.getEndX() - 1;
                    newY = word.getEndY();
                    if (checkLimit(newX, newY, cross)) {
                        if (word.getStartX() >= word.getEndX() && word.getStartY() == word.getEndY())
                            word.add(newX, newY, cross[newX][newY]);
                        else
                            word = null;
                    } else
                        word = null;
                    break;
                }
                case DOWN:{
                    newX = word.getEndX() + 1;
                    newY = word.getEndY();
                    if (checkLimit(newX, newY, cross)) {
                        if (word.getStartX() <= word.getEndX() && word.getStartY() == word.getEndY())
                            word.add(newX, newY, cross[newX][newY]);
                        else
                            word = null;
                    } else
                        word = null;
                    break;
                }
                case LEFT:{
                    newX = word.getEndX();
                    newY = word.getEndY() - 1;
                    if (checkLimit(newX, newY, cross)) {
                        if (word.getStartX() == word.getEndX() && word.getStartY() >= word.getEndY())
                            word.add(newX, newY, cross[newX][newY]);
                        else
                            word = null;
                    } else
                        word = null;
                    break;
                }
                case RIGHT:{
                    newX = word.getEndX();
                    newY = word.getEndY() + 1;
                    if (checkLimit(newX, newY, cross)) {
                        if (word.getStartX() == word.getEndX() && word.getStartY() <= word.getEndY())
                            word.add(newX, newY, cross[newX][newY]);
                        else
                            word = null;
                    } else
                        word = null;
                    break;
                }
                case UP_LEFT:{
                    newX = word.getEndX() - 1;
                    newY = word.getEndY() - 1;
                    if (checkLimit(newX, newY, cross)) {
                        if (word.getStartX() >= word.getEndX() && word.getStartY() >= word.getEndY())
                            word.add(newX, newY, cross[newX][newY]);
                        else
                            word = null;
                    } else
                        word = null;
                    break;
                }
                case UP_RIGHT:{
                    newX = word.getEndX() - 1;
                    newY = word.getEndY() + 1;
                    if (checkLimit(newX, newY, cross)) {
                        if (word.getStartX() >= word.getEndX() && word.getStartY() <= word.getEndY())
                            word.add(newX, newY, cross[newX][newY]);
                        else
                            word = null;
                    } else
                        word = null;
                    break;
                }
                case DOWN_LEFT:{
                    newX = word.getEndX() + 1;
                    newY = word.getEndY() - 1;
                    if (checkLimit(newX, newY, cross)) {
                        if (word.getStartX() <= word.getEndX() && word.getStartY() >= word.getEndY())
                            word.add(newX, newY, cross[newX][newY]);
                        else
                            word = null;
                    } else
                        word = null;
                    break;
                }
                case DOWN_RIGHT:{
                    newX = word.getEndX() + 1;
                    newY = word.getEndY() + 1;
                    if (checkLimit(newX, newY, cross)) {
                        if (word.getStartX() <= word.getEndX() && word.getStartY() <= word.getEndY())
                            word.add(newX, newY, cross[newX][newY]);
                        else
                            word = null;
                    } else
                        word = null;
                    break;
                }
            }

        }

        public static boolean checkLimit(int x, int y, int[][] cross){
            if (x < 0 || y < 0) return false;
            if (x >= cross.length) return false;
            if (cross.length > 0 && y >= cross[0].length) return false;
            if (cross.length == 0) return false;

            return true;
        }

        public static Word getWord(String text, Go go, int startX, int startY, int[][] cross){

            if (!checkLimit(startX, startY, cross)) return null;

            Word word = new Word(startX, startY, cross[startX][startY]);
            for (int i = 1; i < text.length(); i++) {
                {
                    addNext(word, go, cross);
                }
            }

            if (word != null && text.equals(word.getText()))
                return word;
            else return null;
        }
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;

        private int endX;
        private int endY;


        public int getStartX() {
            //return startX;
            return startY;
        }

        public int getStartY() {
            //return startY;
            return startX;
        }

        public int getEndX() {
            //return endX;
            return endY;
        }

        public int getEndY() {
            //return endY;
            return endX;
        }

        public String getText() {
            return text;
        }

        public Word(String text) {
            this.text = text;
        }

        public Word(int x, int y, int text){
//            this.startX = x;
//            this.startY = y;
//            this.endX = x;
//            this.endY = y;

            this.startY = x;
            this.startX = y;
            this.endY = x;
            this.endX = y;

            this.text = Character.toString((char) text);
        }

        public void add(int x, int y, int text){
            //this.endX = x;
            //this.endY = y;
            this.endY = x;
            this.endX = y;
            this.text += Character.toString((char) text);
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }



        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }

    public enum Go{
        UP,
        DOWN,
        LEFT,
        RIGHT,
        UP_LEFT,
        UP_RIGHT,
        DOWN_LEFT,
        DOWN_RIGHT

    }
}
