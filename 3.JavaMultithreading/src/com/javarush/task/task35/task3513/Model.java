package com.javarush.task.task35.task3513;

import java.util.*;

public class Model {

    private Stack<Tile[][]> previousStates = new Stack<>();
    private Stack<Integer> previousScores = new Stack<>();
    private boolean isSaveNeeded = true;

    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    protected int maxTile;
    protected int score;


    public Model() {
        resetGameTiles();
        //isSaveNeeded = false;
        previousStates = new Stack<>();
        previousScores = new Stack<>();
    }

    public void saveState(Tile[][] param){

        Tile[][] copy = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                copy[i][j] = new Tile(param[i][j].value);
            }

        }
        previousStates.push(copy);
        previousScores.push(score);
        isSaveNeeded = false;
    }

    public void rollback(){
        if (previousScores.size() > 0 && previousStates.size() > 0) {
            gameTiles = previousStates.pop();
            score = previousScores.pop();
        }
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }


    private List<Tile> getEmptyTiles(){
        List<Tile> list = new ArrayList<>();
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                if (gameTiles[i][j].isEmpty())
                    list.add(gameTiles[i][j]);
            }
        }
        return list;
    }

    private void addTile(){
        List<Tile> list = getEmptyTiles();
        if (list.size() > 0)
            list.get((int)(Math.random() * list.size())).value = (Math.random() < 0.9 ? 2 : 4);
    }

    public void resetGameTiles(){
        gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        maxTile = 0;
        score = 0;
        addTile();
        addTile();
    }

    public void left(){
        if (isSaveNeeded)
            saveState(gameTiles);
        boolean res = false;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            if (compressTiles(gameTiles[i])) res = true;
            if (mergeTiles(gameTiles[i])) res = true;
        }
        if (res)
            addTile();
    }

    public void down(){
        saveState(gameTiles);
        rotateClockwise();
        left();
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
    }

    public void right(){
        saveState(gameTiles);
        rotateClockwise();
        rotateClockwise();
        left();
        rotateClockwise();
        rotateClockwise();
    }

    public void up(){
        saveState(gameTiles);
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
        left();
        rotateClockwise();
    }



    public void rotateClockwise() {
        int[][] rezult = new int[FIELD_WIDTH][FIELD_WIDTH];

        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                rezult[i][j] = gameTiles[FIELD_WIDTH - j - 1][i].value;
            }
        }

        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j].value = rezult[i][j];
            }
        }
    }

    private boolean compressTiles(Tile[] tiles) {
        boolean res = false;
        for (int i = 0; i < tiles.length; i++) {
            for (int j = i + 1; j < tiles.length; j++) {
                if (tiles[i].value == 0 && tiles[j].value > 0) {
                    int buf = tiles[i].value;
                    tiles[i].value = tiles[j].value;
                    tiles[j].value = buf;
                    res = true;
                    break;
                }
            }
        }
        return res;
    }

    private boolean mergeTiles(Tile[] tiles){
        boolean res = false;

        for (int i = 1; i < tiles.length; i++) {
            if (tiles[i - 1].value == tiles[i].value && tiles[i - 1].value !=0) {
                tiles[i - 1].value += tiles[i].value;
                score += tiles[i - 1].value;
                tiles[i].value = 0;
                res = true;
                if (tiles[i - 1].value > maxTile)
                    maxTile = tiles[i - 1].value;
            }
            //else i++;
        }
        if (res)
            compressTiles(tiles);

        return res;
    }

    public boolean canMove(){
        if (getEmptyTiles().size() > 0)
            return true;

        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                if (checkClose(i, j))
                    return true;
            }
        }

        return false;
    }

    private boolean checkClose(int i, int j){

        if (i > 0 && gameTiles[i-1][j].value == gameTiles[i][j].value)
            return true;
        if (i < FIELD_WIDTH -1 && gameTiles[i+1][j].value == gameTiles[i][j].value)
            return true;
        if (j > 0 && gameTiles[i][j-1].value == gameTiles[i][j].value)
            return true;
        if (j < FIELD_WIDTH -1 && gameTiles[i][j+1].value == gameTiles[i][j].value)
            return true;
        
        return false;
    }

    void randomMove(){
        int n = ((int) (Math.random() * 100)) % 4;

        switch (n){
            case 0:
                left();
                break;
            case 1:
                right();
                break;
            case 2:
                up();
                break;
            case 3:
                down();
                break;
        }
    }

    boolean hasBoardChanged(){
        Tile[][] steak = previousStates.peek();
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                sum1 += steak[i][j].value;
                sum2 += gameTiles[i][j].value;
            }
        }
        return sum1 != sum2;
    }

    MoveEfficiency getMoveEfficiency(Move move){
        MoveEfficiency moveEfficiency;
        move.move();
        if (!hasBoardChanged())
            moveEfficiency = new MoveEfficiency(-1, 0, move);
        else
            moveEfficiency = new MoveEfficiency(getEmptyTiles().size(), score, move);
        rollback();
        return moveEfficiency;
    }

    void autoMove(){
        PriorityQueue<MoveEfficiency> priorityQueue = new PriorityQueue<>(4, Collections.reverseOrder());
        priorityQueue.offer(getMoveEfficiency(this::left));
        priorityQueue.offer(getMoveEfficiency(this::right));
        priorityQueue.offer(getMoveEfficiency(this::up));
        priorityQueue.offer(getMoveEfficiency(this::down));

        MoveEfficiency best = priorityQueue.peek();
        best.getMove().move();
    }

}
