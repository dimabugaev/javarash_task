package com.javarush.games.minesweeper;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

import java.util.ArrayList;
import java.util.List;

public class MinesweeperGame extends Game {
    private static final int SIDE = 9;
    private static final String MINE = "\uD83D\uDCA3";
    private static final String FLAG = "\uD83D\uDEA9";


    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private int countMinesOnField;
    private int countFlags;
    private boolean isGameStopped;
    private int countClosedTiles = SIDE*SIDE;
    private int score = 0;

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
    }

    public void onMouseLeftClick(int x, int y){
        
        if (isGameStopped) restart(); else openTile(x, y);
    }

    public void onMouseRightClick(int x, int y) { markTile(x, y);}

    private void restart(){
        isGameStopped = false;
        countClosedTiles = SIDE*SIDE;
        countMinesOnField = 0;
        score = 0;
        setScore(score);
        createGame();

    }

    private void gameOver(){

        isGameStopped = true;
        showMessageDialog(Color.ALICEBLUE, "вы проиграли хахаха!!!", Color.BLACK, 20);
    }

    private void win(){

        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {

                if (gameField[y][x].isMine) setCellValueEx(x, y, Color.GOLD, MINE);

            }
        }
        isGameStopped = true;
        showMessageDialog(Color.ALICEBLUE, "ты победил, но все равно лошара :)", Color.RED, 20);
    }

    private void markTile(int x, int y){
        if (isGameStopped || gameField[y][x].isOpen || (countFlags == 0 & !gameField[y][x].isFlag)){
            return;
        }
        gameField[y][x].isFlag = !gameField[y][x].isFlag;
        if (gameField[y][x].isFlag){
            countFlags --;
            setCellValue(x, y, FLAG);
            setCellColor(x, y, Color.YELLOW);
        }
        else{
            countFlags ++;
            setCellValue(x, y, "");
            setCellColor(x, y, Color.ORANGE);
        }

    }

    private void openTile(int x, int y){

        if (isGameStopped || gameField[y][x].isFlag || gameField[y][x].isOpen){
            return;
        }
        gameField[y][x].isOpen = true;
        countClosedTiles--;

        if (gameField[y][x].isMine){
            //setCellValue(x, y, MINE);
            setCellValueEx(x, y, Color.RED, MINE);
            gameOver();
        }
        else{
            score += 5;
            setScore(score);
            if (gameField[y][x].countMineNeighbors == 0){

                for(GameObject neighbor : getNeighbors(gameField[y][x])){
                    openTile(neighbor.x, neighbor.y);
                    }
                //setCellValue(x, y,"");
                setCellValueEx(x, y, Color.DARKGREY, "");
            }
            else{
                setCellNumber(x, y, gameField[y][x].countMineNeighbors);
                setCellColor(x, y, Color.GREEN);
            }

            if (countClosedTiles == countMinesOnField){
                win();
            }
        }
    }

    private void createGame() {
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                boolean isMine = getRandomNumber(10) < 1;
                if (isMine) {
                    countMinesOnField++;
                }
                gameField[y][x] = new GameObject(x, y, isMine);
                setCellValue(x, y, "");
                setCellColor(x, y, Color.ORANGE);
            }
        }

        countMineNeighbors();
        countFlags = countMinesOnField;
        //isGameStopped = false;
    }



    private void countMineNeighbors(){
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                if (gameField[i][j].isMine){
                    for(GameObject neighbor : getNeighbors(gameField[i][j])){
                        if (!neighbor.isMine){
                            neighbor.countMineNeighbors +=1;
                        }
                    }
                }
            }
        }
    }

    private List<GameObject> getNeighbors(GameObject gameObject) {
        List<GameObject> result = new ArrayList<>();
        for (int y = gameObject.y - 1; y <= gameObject.y + 1; y++) {
            for (int x = gameObject.x - 1; x <= gameObject.x + 1; x++) {
                if (y < 0 || y >= SIDE) {
                    continue;
                }
                if (x < 0 || x >= SIDE) {
                    continue;
                }
                if (gameField[y][x] == gameObject) {
                    continue;
                }
                result.add(gameField[y][x]);
            }
        }
        return result;
    }
}