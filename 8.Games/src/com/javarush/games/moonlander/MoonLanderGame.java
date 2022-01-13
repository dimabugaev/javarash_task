package com.javarush.games.moonlander;


import com.javarush.engine.cell.*;



public class MoonLanderGame extends Game {
    public final static int WIDTH = 64;
    public final static int HEIGHT = 64;
    private Rocket rocket;
    private GameObject landscape;
    private boolean isUpPressed;
    private boolean isLeftPressed;
    private boolean isRightPressed;
    private GameObject platform;
    private boolean isGameStopped;
    private int score;

    @Override
    public void initialize() {
        //super.initialize();
        setScreenSize(WIDTH, HEIGHT);
        createGame();
        showGrid(false);
    }

    private void createGame(){
        createGameObjects();
        drawScene();
        setTurnTimer(50);

        isUpPressed = false;
        isLeftPressed = false;
        isRightPressed = false;
        isGameStopped = false;

        score = 1000;
    }

    @Override
    public void onTurn(int step) {
        //super.onTurn(step);
        if (score > 0)
            score -= 1;


            //gameOver();

        rocket.move(isUpPressed, isLeftPressed, isRightPressed);

        check();

        setScore(score);

        drawScene();


    }

    @Override
    public void setCellColor(int x, int y, Color color) {
        if (x >= 0 && x < WIDTH && y >= 0 && y < HEIGHT)
            super.setCellColor(x, y, color);
    }

    private void drawScene(){

        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                setCellColor(j, i, Color.BLACK);
            }
        }

        landscape.draw(this);
        rocket.draw(this);
    }

    private void createGameObjects(){
        rocket = new Rocket(WIDTH/2,0);
        landscape = new GameObject(0, 25, ShapeMatrix.LANDSCAPE);

        platform = new GameObject(23, MoonLanderGame.HEIGHT - 1, ShapeMatrix.PLATFORM);
    }

    @Override
    public void onKeyPress(Key key) {
        switch (key){

            case LEFT:
                isLeftPressed = true;
                isRightPressed = false;
                break;
            case RIGHT:
                isRightPressed = true;
                isLeftPressed = false;
                break;
            case UP:
                isUpPressed = true;
                break;
            case SPACE:
                if (isGameStopped)
                    createGame();
                break;
        }
    }

    @Override
    public void onKeyReleased(Key key) {

        switch (key){

            case LEFT:
                isLeftPressed = false;
                break;
            case RIGHT:
                isRightPressed = false;
                break;
            case UP:
                isUpPressed = false;
                break;
//            case SPACE:
//                if (isGameStopped)
//                    createGame();
//                break;
        }


    }

    private void check(){
        if (rocket.isCollision(landscape) && !(rocket.isCollision(platform) && rocket.isStopped()))
            gameOver();

        if (rocket.isCollision(platform) && rocket.isStopped())
            win();
    }

    private void win(){
        rocket.land();
        isGameStopped = true;
        showMessageDialog(Color.ORANGE, "Вы сделали это!!", Color.GREEN, 45);
        stopTurnTimer();
    }

    private void gameOver(){
        rocket.crash();
        isGameStopped = true;
        showMessageDialog(Color.ORANGE, "This is CRASH", Color.GREEN, 45);
        stopTurnTimer();
        score = 0;
    }
}
