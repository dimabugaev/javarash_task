package com.javarush.games.racer;

import com.javarush.engine.cell.*;

public class RacerGame extends Game {

    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    public static final int CENTER_X = WIDTH/2;
    public static final int ROADSIDE_WIDTH = 14;

    private RoadMarking roadMarking;
    private PlayerCar player;


    @Override
    public void initialize() {
        showGrid(false);
        setScreenSize(WIDTH, HEIGHT);
        createGame();

    }

    private void createGame(){

        roadMarking = new RoadMarking();
        player = new PlayerCar();
        drawScene();
        setTurnTimer(40);
    }

    private void drawScene(){
        drawField();
        roadMarking.draw(this);
        player.draw(this);
    }

    private void drawField(){
        for (int x = 0; x < WIDTH; x++) {
        for (int y = 0; y < HEIGHT; y++) {
            //for (int x = 0; x < WIDTH; x++) {
                if (x == CENTER_X) {
                    setCellColor(CENTER_X, y, Color.WHITE);
                    continue;
                }
                if (x >= ROADSIDE_WIDTH && x < (WIDTH - ROADSIDE_WIDTH)){
                    setCellColor(x, y, Color.DIMGREY);
                    continue;
                }
                else
                    setCellColor(x, y, Color.GREEN);
            }
        }
    }

    @Override
    public void setCellColor(int x, int y, Color color) {
        if (x < 0 || x >= WIDTH) return;
        if (y < 0 || y >= HEIGHT) return;

        super.setCellColor(x, y, color);
    }

    private void moveAll(){
        roadMarking.move(player.speed);
        player.move();
    }

    @Override
    public void onTurn(int step) {
        moveAll();
        drawScene();

    }

    @Override
    public void onKeyPress(Key key) {
        switch (key){
            case LEFT:
                player.setDirection(Direction.LEFT);
                break;
            case RIGHT:
                player.setDirection(Direction.RIGHT);
                break;
        }
    }

    @Override
    public void onKeyReleased(Key key) {
        if (key == Key.RIGHT && player.getDirection() == Direction.RIGHT)
            player.setDirection(Direction.NONE);
        if (key == Key.LEFT && player.getDirection() == Direction.LEFT)
            player.setDirection(Direction.NONE);
    }
}
