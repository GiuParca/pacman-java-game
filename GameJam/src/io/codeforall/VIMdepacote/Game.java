package io.codeforall.VIMdepacote;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.lang.reflect.Array;
import java.util.Arrays;
MYCHANGE
public class Game implements KeyboardHandler {
    private Boolean[] arrayCD;
    private boolean canMove;
    private Ball[] balls = new Ball[441];
    private int ballsRemaining;
    private Text scoreText;

    private RectagleObject[] ghosts = new RectagleObject[4];
    RectagleObject[] ghostMoveCheckers = new RectagleObject[4];
    RectagleObject[] gameObjects;
    //Picture pacman = new Picture(25, 25, "src/pacman-png-25195.png");
    RectagleObject playerRectangle = new RectagleObject(25, 25, 30, 30);
    RectagleObject moveChecker = new RectagleObject(25, 25, 30, 30);
    ;


    public Game() {


        //Picture bg = new Picture(0,0,"src/backgrounds.png");
        //bg.draw();
        playerRectangle.setColor(Color.ORANGE);
        playerRectangle.fill();
        startBackground();
        this.keyboardSetup();
        //ghost.fill();


    }

    public void startGhost() throws InterruptedException {


        while (true) {
            for (int i = 0; i < ghosts.length; i++) {
                int[] directionsPossible = new int[3];
                for (int j = 0; j < ghosts.length - 1; j++) {

                    if (j != ghosts[j].lastMove) {
                        directionsPossible[j] = j;
                    }

                }
                System.out.println(Arrays.toString(directionsPossible));

                int direction = 0;
                double rdn = Math.random();
                System.out.println(rdn);

                if (rdn > 0.66) {
                    direction = directionsPossible[0];
                    System.out.println(direction);
                } else if (rdn > 0.33) {
                    direction = directionsPossible[1];
                    System.out.println(direction);
                } else {
                    direction = directionsPossible[2];
                    System.out.println(direction);

                }


                switch (direction) {
                    case 0:
                        //for (int i = 0; i < 7; i++) {
                        ghostMoveCheckers[i].getRectangle().translate(5, 0);
                        ghostMoveCheckers[i].setObjectBounds(ghostMoveCheckers[i].getRectangle().getX() + ghostMoveCheckers[i].getRectangle().getWidth(), ghostMoveCheckers[i].getRectangle().getY(), ghostMoveCheckers[i].getRectangle().getX(), ghostMoveCheckers[i].getRectangle().getY() + ghostMoveCheckers[i].getRectangle().getHeight());
                        if (cD(ghostMoveCheckers[i])) {
                            ghosts[i].getRectangle().translate(35, 0);
                            ghostMoveCheckers[i].getRectangle().translate(30, 0);
                            ghosts[i].setObjectBounds(ghosts[i].getRectangle().getX() + ghosts[i].getRectangle().getWidth(), ghosts[i].getRectangle().getY(), ghosts[i].getRectangle().getX(), ghosts[i].getRectangle().getY() + ghosts[i].getRectangle().getHeight());
                            ghosts[i].lastMove = 0;
                        } else {
                            ghostMoveCheckers[i].getRectangle().translate(-5, 0);
                            ghostMoveCheckers[i].setObjectBounds(ghostMoveCheckers[i].getRectangle().getX() + ghostMoveCheckers[i].getRectangle().getWidth(), ghostMoveCheckers[i].getRectangle().getY(), ghostMoveCheckers[i].getRectangle().getX(), ghostMoveCheckers[i].getRectangle().getY() + ghostMoveCheckers[i].getRectangle().getHeight());
                        }

                        //}
                        break;

                    case 1:
                        //for (int i = 0; i < 7; i++) {
                        ghostMoveCheckers[i].getRectangle().translate(-5, 0);
                        ghostMoveCheckers[i].setObjectBounds(ghostMoveCheckers[i].getRectangle().getX() + ghostMoveCheckers[i].getRectangle().getWidth(), ghostMoveCheckers[i].getRectangle().getY(), ghostMoveCheckers[i].getRectangle().getX(), ghostMoveCheckers[i].getRectangle().getY() + ghostMoveCheckers[i].getRectangle().getHeight());
                        if (cD(ghostMoveCheckers[i])) {
                            ghosts[i].getRectangle().translate(-35, 0);
                            ghostMoveCheckers[i].getRectangle().translate(-30, 0);
                            ghosts[i].setObjectBounds(ghosts[i].getRectangle().getX() + ghosts[i].getRectangle().getWidth(), ghosts[i].getRectangle().getY(), ghosts[i].getRectangle().getX(), ghosts[i].getRectangle().getY() + ghosts[i].getRectangle().getHeight());
                            ghosts[i].lastMove = 1;
                        } else {
                            ghostMoveCheckers[i].getRectangle().translate(5, 0);
                            ghostMoveCheckers[i].setObjectBounds(ghostMoveCheckers[i].getRectangle().getX() + ghostMoveCheckers[i].getRectangle().getWidth(), ghostMoveCheckers[i].getRectangle().getY(), ghostMoveCheckers[i].getRectangle().getX(), ghostMoveCheckers[i].getRectangle().getY() + ghostMoveCheckers[i].getRectangle().getHeight());

                        }

                        //}
                        break;
                    case 2:
                        //for (int i = 0; i < 7; i++) {
                        ghostMoveCheckers[i].getRectangle().translate(0, -5);
                        ghostMoveCheckers[i].setObjectBounds(ghostMoveCheckers[i].getRectangle().getX() + ghostMoveCheckers[i].getRectangle().getWidth(), ghostMoveCheckers[i].getRectangle().getY(), ghostMoveCheckers[i].getRectangle().getX(), ghostMoveCheckers[i].getRectangle().getY() + ghostMoveCheckers[i].getRectangle().getHeight());
                        if (cD(ghostMoveCheckers[i])) {
                            ghosts[i].getRectangle().translate(0, -35);
                            ghostMoveCheckers[i].getRectangle().translate(0, -30);
                            ghosts[i].setObjectBounds(ghosts[i].getRectangle().getX() + ghosts[i].getRectangle().getWidth(), ghosts[i].getRectangle().getY(), ghosts[i].getRectangle().getX(), ghosts[i].getRectangle().getY() + ghosts[i].getRectangle().getHeight());
                            ghosts[i].lastMove = 2;
                        } else {
                            ghostMoveCheckers[i].getRectangle().translate(0, 5);
                            ghostMoveCheckers[i].setObjectBounds(ghostMoveCheckers[i].getRectangle().getX() + ghostMoveCheckers[i].getRectangle().getWidth(), ghostMoveCheckers[i].getRectangle().getY(), ghostMoveCheckers[i].getRectangle().getX(), ghostMoveCheckers[i].getRectangle().getY() + ghostMoveCheckers[i].getRectangle().getHeight());

                        }

                        // }
                        break;
                    case 3:
                        //for (int i = 0; i < 7; i++) {
                        ghostMoveCheckers[i].getRectangle().translate(0, 5);
                        ghostMoveCheckers[i].setObjectBounds(ghostMoveCheckers[i].getRectangle().getX() + ghostMoveCheckers[i].getRectangle().getWidth(), ghostMoveCheckers[i].getRectangle().getY(), ghostMoveCheckers[i].getRectangle().getX(), ghostMoveCheckers[i].getRectangle().getY() + ghostMoveCheckers[i].getRectangle().getHeight());
                        if (cD(ghostMoveCheckers[i])) {
                            ghosts[i].getRectangle().translate(0, 35);
                            ghostMoveCheckers[i].getRectangle().translate(0, 30);
                            ghosts[i].setObjectBounds(ghosts[i].getRectangle().getX() + ghosts[i].getRectangle().getWidth(), ghosts[i].getRectangle().getY(), ghosts[i].getRectangle().getX(), ghosts[i].getRectangle().getY() + ghosts[i].getRectangle().getHeight());
                            ghosts[i].lastMove = 3;
                        } else {
                            ghostMoveCheckers[i].getRectangle().translate(0, -5);
                            ghostMoveCheckers[i].setObjectBounds(ghostMoveCheckers[i].getRectangle().getX() + ghostMoveCheckers[i].getRectangle().getWidth(), ghostMoveCheckers[i].getRectangle().getY(), ghostMoveCheckers[i].getRectangle().getX(), ghostMoveCheckers[i].getRectangle().getY() + ghostMoveCheckers[i].getRectangle().getHeight());

                        }

                        //}
                        break;
                }
            }
            Thread.sleep(350);
        }

    }

    public boolean cD(GameObjects object) {
        arrayCD = new Boolean[gameObjects.length];
        for (int i = 0; i < gameObjects.length; i++) {
            arrayCD[i] = CollisionDetector.collisionDetector(object, gameObjects[i]);
        }
        return CollisionDetector.canMove(arrayCD);
        // System.out.println(canMove);

    }

    public void keyboardSetup() {

        Keyboard keyboard = new Keyboard(this);

        // Event configuration

        KeyboardEvent rightArrow = new KeyboardEvent();
        rightArrow.setKey(KeyboardEvent.KEY_RIGHT);
        rightArrow.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent leftArrow = new KeyboardEvent();
        leftArrow.setKey(KeyboardEvent.KEY_LEFT);
        leftArrow.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent upArrow = new KeyboardEvent();
        upArrow.setKey(KeyboardEvent.KEY_UP);
        upArrow.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent downArrow = new KeyboardEvent();
        downArrow.setKey(KeyboardEvent.KEY_DOWN);
        downArrow.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        //Associate event to keyboard

        keyboard.addEventListener(rightArrow);
        keyboard.addEventListener(leftArrow);
        keyboard.addEventListener(upArrow);
        keyboard.addEventListener(downArrow);

    }

    public Color randomColor() {
        int rdn = (int) Math.round(Math.random() * 4);
        switch (rdn) {
            case 1:
                return Color.CYAN;
            case 2:
                return Color.GRAY;
            case 3:
                return Color.GREEN;
            case 4:
                return Color.MAGENTA;
            default:
                return Color.PINK;
        }

    }

    public void startBackground() {
        gameObjects = new RectagleObject[37];
        gameObjects[0] = new RectagleObject(60, 60, 100, 65);
        gameObjects[7] = new RectagleObject(200, 60, 135, 65);
        gameObjects[8] = new RectagleObject(445, 60, 135, 65);
        gameObjects[9] = new RectagleObject(620, 60, 100, 65);
        gameObjects[13] = new RectagleObject(60, 165, 100, 30);
        gameObjects[14] = new RectagleObject(620, 165, 100, 30);
        gameObjects[15] = new RectagleObject(200, 165, 30, 170);
        gameObjects[16] = new RectagleObject(550, 165, 30, 170);
        gameObjects[17] = new RectagleObject(230, 235, 105, 30);
        gameObjects[18] = new RectagleObject(445, 235, 105, 30);
        gameObjects[19] = new RectagleObject(375, 165, 30, 100);
        gameObjects[20] = new RectagleObject(270, 165, 240, 30);
        gameObjects[21] = new RectagleObject(375, 480, 30, 100);
        gameObjects[22] = new RectagleObject(270, 480, 240, 30);
        gameObjects[23] = new RectagleObject(375, 620, 30, 100);
        gameObjects[24] = new RectagleObject(270, 620, 240, 30);
        gameObjects[25] = new RectagleObject(20, 235, 140, 275);
        gameObjects[26] = new RectagleObject(620, 235, 140, 275);
        gameObjects[27] = new RectagleObject(200, 375, 30, 135);
        gameObjects[28] = new RectagleObject(550, 375, 30, 135);
        gameObjects[29] = new RectagleObject(200, 550, 135, 30);
        gameObjects[10] = new RectagleObject(445, 550, 135, 30);
        gameObjects[11] = new RectagleObject(60, 550, 100, 30);
        gameObjects[12] = new RectagleObject(620, 550, 100, 30);
        gameObjects[1] = new RectagleObject(130, 580, 30, 70);
        gameObjects[30] = new RectagleObject(620, 580, 30, 70);
        gameObjects[31] = new RectagleObject(20, 620, 70, 30);
        gameObjects[32] = new RectagleObject(690, 620, 70, 30);
        gameObjects[33] = new RectagleObject(200, 620, 30, 70);
        gameObjects[34] = new RectagleObject(550, 620, 30, 70);
        gameObjects[35] = new RectagleObject(60, 690, 275, 30);
        gameObjects[36] = new RectagleObject(445, 690, 275, 30);

        gameObjects[2] = new RectagleObject(375, 10, 30, 115);
        gameObjects[3] = new RectagleObject(10, 10, 760, 10);
        gameObjects[4] = new RectagleObject(10, 10, 10, 760);
        gameObjects[5] = new RectagleObject(760, 10, 10, 760);
        gameObjects[6] = new RectagleObject(10, 760, 760, 10);
        int l = 0;
        for (int j = 1; j < 22; j++) {
            for (int i = 0; i < 21; i++) {
                //Ellipse ball = new Ellipse(35 + (i * 35), 35 * j, 10, 10);
                balls[l] = new Ball(35 + (i * 35), 35 * j, 10, 10);
                if (CollisionDetector.collisionDetector(playerRectangle, balls[l])) {
                    balls[l].setEaten(true);
                }
                if (cD(balls[l]) && !CollisionDetector.collisionDetector(playerRectangle, balls[l])) {
                    balls[l].fill();
                    ballsRemaining++;
                }
                l++;
            }
        }
        for (int i = 0; i < gameObjects.length; i++) {
            gameObjects[i].setColor(Color.BLUE);
            gameObjects[i].fill();

        }
        for (int i = 0; i < ghostMoveCheckers.length; i++) {
            ghostMoveCheckers[i] = new RectagleObject(375, 340, 30, 30);


        }
        for (int i = 0; i < ghosts.length; i++) {

            ghosts[i] = new RectagleObject(375, 340, 30, 30);

            ghosts[i].setColor(randomColor());
            ghosts[i].fill();

        }
        scoreText = new Text(60, 345, String.valueOf(ballsRemaining));
        scoreText.setColor(Color.BLACK);
        scoreText.grow(30, 30);
        scoreText.draw();
        System.out.println(balls.length);
        System.out.println("===========================");
        System.out.println(l);


    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {


        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT:
                //for (int i = 0; i < 7; i++) {
                moveChecker.getRectangle().translate(5, 0);
                moveChecker.setObjectBounds(moveChecker.getRectangle().getX() + moveChecker.getRectangle().getWidth(), moveChecker.getRectangle().getY(), moveChecker.getRectangle().getX(), moveChecker.getRectangle().getY() + moveChecker.getRectangle().getHeight());
                if (cD(moveChecker)) {
                    playerRectangle.getRectangle().translate(35, 0);
                    moveChecker.getRectangle().translate(30, 0);
                    playerRectangle.setObjectBounds(playerRectangle.getRectangle().getX() + playerRectangle.getRectangle().getWidth(), playerRectangle.getRectangle().getY(), playerRectangle.getRectangle().getX(), playerRectangle.getRectangle().getY() + playerRectangle.getRectangle().getHeight());
                    for (Ball ball : balls) {
                        if (!ball.isEaten() && CollisionDetector.collisionDetector(playerRectangle, ball)) {
                            ball.delete();
                            ball.setEaten(true);
                            ballsRemaining--;
                            scoreText.setText(String.valueOf(ballsRemaining));
                        }
                    }
                } else {
                    moveChecker.getRectangle().translate(-5, 0);
                    moveChecker.setObjectBounds(moveChecker.getRectangle().getX() + moveChecker.getRectangle().getWidth(), moveChecker.getRectangle().getY(), moveChecker.getRectangle().getX(), moveChecker.getRectangle().getY() + moveChecker.getRectangle().getHeight());
                }

                //}
                break;

            case KeyboardEvent.KEY_LEFT:
                //for (int i = 0; i < 7; i++) {
                moveChecker.getRectangle().translate(-5, 0);
                moveChecker.setObjectBounds(moveChecker.getRectangle().getX() + moveChecker.getRectangle().getWidth(), moveChecker.getRectangle().getY(), moveChecker.getRectangle().getX(), moveChecker.getRectangle().getY() + moveChecker.getRectangle().getHeight());
                if (cD(moveChecker)) {
                    playerRectangle.getRectangle().translate(-35, 0);
                    moveChecker.getRectangle().translate(-30, 0);
                    playerRectangle.setObjectBounds(playerRectangle.getRectangle().getX() + playerRectangle.getRectangle().getWidth(), playerRectangle.getRectangle().getY(), playerRectangle.getRectangle().getX(), playerRectangle.getRectangle().getY() + playerRectangle.getRectangle().getHeight());
                    for (Ball ball : balls) {
                        if (!ball.isEaten() && CollisionDetector.collisionDetector(playerRectangle, ball)) {
                            ball.delete();
                            ball.setEaten(true);
                            ballsRemaining--;
                            scoreText.setText(String.valueOf(ballsRemaining));
                        }
                    }
                } else {
                    moveChecker.getRectangle().translate(5, 0);
                    moveChecker.setObjectBounds(moveChecker.getRectangle().getX() + moveChecker.getRectangle().getWidth(), moveChecker.getRectangle().getY(), moveChecker.getRectangle().getX(), moveChecker.getRectangle().getY() + moveChecker.getRectangle().getHeight());

                }

                //}
                break;
            case KeyboardEvent.KEY_UP:
                //for (int i = 0; i < 7; i++) {
                moveChecker.getRectangle().translate(0, -5);
                moveChecker.setObjectBounds(moveChecker.getRectangle().getX() + moveChecker.getRectangle().getWidth(), moveChecker.getRectangle().getY(), moveChecker.getRectangle().getX(), moveChecker.getRectangle().getY() + moveChecker.getRectangle().getHeight());
                if (cD(moveChecker)) {
                    playerRectangle.getRectangle().translate(0, -35);
                    moveChecker.getRectangle().translate(0, -30);
                    playerRectangle.setObjectBounds(playerRectangle.getRectangle().getX() + playerRectangle.getRectangle().getWidth(), playerRectangle.getRectangle().getY(), playerRectangle.getRectangle().getX(), playerRectangle.getRectangle().getY() + playerRectangle.getRectangle().getHeight());
                    for (Ball ball : balls) {
                        if (!ball.isEaten() && CollisionDetector.collisionDetector(playerRectangle, ball)) {
                            ball.delete();
                            ball.setEaten(true);
                            ballsRemaining--;
                            scoreText.setText(String.valueOf(ballsRemaining));
                        }
                    }
                } else {
                    moveChecker.getRectangle().translate(0, 5);
                    moveChecker.setObjectBounds(moveChecker.getRectangle().getX() + moveChecker.getRectangle().getWidth(), moveChecker.getRectangle().getY(), moveChecker.getRectangle().getX(), moveChecker.getRectangle().getY() + moveChecker.getRectangle().getHeight());

                }

                // }
                break;
            case KeyboardEvent.KEY_DOWN:
                //for (int i = 0; i < 7; i++) {
                moveChecker.getRectangle().translate(0, 5);
                moveChecker.setObjectBounds(moveChecker.getRectangle().getX() + moveChecker.getRectangle().getWidth(), moveChecker.getRectangle().getY(), moveChecker.getRectangle().getX(), moveChecker.getRectangle().getY() + moveChecker.getRectangle().getHeight());
                if (cD(moveChecker)) {
                    playerRectangle.getRectangle().translate(0, 35);
                    moveChecker.getRectangle().translate(0, 30);
                    playerRectangle.setObjectBounds(playerRectangle.getRectangle().getX() + playerRectangle.getRectangle().getWidth(), playerRectangle.getRectangle().getY(), playerRectangle.getRectangle().getX(), playerRectangle.getRectangle().getY() + playerRectangle.getRectangle().getHeight());
                } else {
                    moveChecker.getRectangle().translate(0, -5);
                    moveChecker.setObjectBounds(moveChecker.getRectangle().getX() + moveChecker.getRectangle().getWidth(), moveChecker.getRectangle().getY(), moveChecker.getRectangle().getX(), moveChecker.getRectangle().getY() + moveChecker.getRectangle().getHeight());

                }
                for (Ball ball : balls) {
                    if (!ball.isEaten() && CollisionDetector.collisionDetector(playerRectangle, ball)) {
                        ball.delete();
                        ball.setEaten(true);
                        ballsRemaining--;
                        scoreText.setText(String.valueOf(ballsRemaining));
                    }
                }
                //}
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

}
