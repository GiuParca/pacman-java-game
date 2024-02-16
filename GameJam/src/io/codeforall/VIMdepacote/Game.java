package io.codeforall.VIMdepacote;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;

public class Game implements KeyboardHandler {
    private Boolean[] arrayCD;
    private int counterbolinhas;
    private boolean canMove;
    private Ball[] balls = new Ball[441];
    private int ballsRemaining;
    private Text scoreText;
    private Text scoreTextLives;
    private boolean isGameOver;
    private int currentKey = -1;
    private RectagleObject ghostDoor;
    private int startGameKey = 0;
    private int lifePlayer = 3;
    Picture pacman1;
    Picture pacman2;
    Picture pacman3;
    private int ghostDoorCounterTimer;
    private Rectangle menuBackGround = new Rectangle(10, 10, 760, 760);
    private Picture button = new Picture(334, 334, "src/img_1.png");
    private LinkedList<GhostObject> ghosts = new LinkedList<>();
    private LinkedList<RectagleObject> ghostMoveCheckers = new LinkedList<>();
    //private RectangleObject[] gameObjects;
    private LinkedList<RectagleObject> wallObjects = new LinkedList<>();
    //Picture pacman = new Picture(25, 25, "src/pacman-png-25195.png");
    private PlayerObject playerObject = new PlayerObject(25, 25, 30, 30);
    private RectagleObject moveChecker = new RectagleObject(25, 25, 30, 30);

    private RectagleObject backGround = new RectagleObject(10, 10, 760, 760);
    private boolean superSaiyajin;

    public Game() {

        backGround.fill();
        playerObject.draw();
        startBackground();
        startBalls();
        startGhosts();
        startText();
        startGhostDoor();


        this.keyboardSetup();


    }

    public void moveGhost(int direction, int ghostIndex) {
        switch (direction) {
            case 0:
                //for (int i = 0; i < 7; i++) {
                ghosts.get(ghostIndex).translate(35, 0);
                ghostMoveCheckers.get(ghostIndex).translate(35, 0);
                //}
                break;

            case 1:
                //for (int i = 0; i < 7; i++) {
                ghosts.get(ghostIndex).translate(-35, 0);
                ghostMoveCheckers.get(ghostIndex).translate(-35, 0);
                //}
                break;
            case 2:
                //for (int i = 0; i < 7; i++) {
                ghosts.get(ghostIndex).translate(0, -35);
                ghostMoveCheckers.get(ghostIndex).translate(0, -35);
                break;
            case 3:
                //for (int i = 0; i < 7; i++) {
                ghosts.get(ghostIndex).translate(0, 35);
                ghostMoveCheckers.get(ghostIndex).translate(0, 35);
                break;
        }
    }

    public boolean movePlayer(int directionToMove) throws InterruptedException {

        switch (directionToMove) {
            case 0:
                //for (int i = 0; i < 7; i++) {
                moveChecker.translate(5, 0);
                if (wallsCollisionDetector(moveChecker)) {
                    playerObject.setPicture("src/pacmanRight.png");
                    playerObject.translate(35, 0);
                    moveChecker.translate(30, 0);
                    ballCollision();
                    playerObject.lastMove = 0;
                    return true;
                } else {
                    if (currentKey != playerObject.lastMove) {
                        currentKey = playerObject.lastMove;
                    }

                    moveChecker.translate(-5, 0);
                }

                //}
                break;

            case 1:
                //for (int i = 0; i < 7; i++) {
                moveChecker.translate(-5, 0);
                if (wallsCollisionDetector(moveChecker)) {
                    playerObject.setPicture("src/pacmanLeft.png");
                    playerObject.translate(-35, 0);
                    moveChecker.translate(-30, 0);
                    ballCollision();
                    playerObject.lastMove = 1;
                    return true;
                } else {
                    if (currentKey != playerObject.lastMove) {
                        currentKey = playerObject.lastMove;
                    }
                    moveChecker.translate(5, 0);

                }

                //}
                break;
            case 2:
                //for (int i = 0; i < 7; i++) {
                moveChecker.translate(0, -5);
                if (wallsCollisionDetector(moveChecker)) {
                    playerObject.setPicture("src/pacmanUp.png");
                    playerObject.translate(0, -35);
                    moveChecker.translate(0, -30);
                    ballCollision();
                    playerObject.lastMove = 2;
                    return true;
                } else {
                    if (currentKey != playerObject.lastMove) {
                        currentKey = playerObject.lastMove;
                    }
                    moveChecker.translate(0, 5);

                }

                // }
                break;
            case 3:
                //for (int i = 0; i < 7; i++) {
                moveChecker.translate(0, 5);
                if (wallsCollisionDetector(moveChecker)) {
                    playerObject.setPicture("src/pacmanDown.png");
                    playerObject.translate(0, 35);
                    moveChecker.translate(0, 30);
                    ballCollision();
                    playerObject.lastMove = 3;
                    return true;
                } else {
                    if (currentKey != playerObject.lastMove) {
                        currentKey = playerObject.lastMove;
                    }
                    moveChecker.translate(0, -5);

                }

                //}
                break;
        }

        return false;

    }

    private void ballCollision() throws InterruptedException {
        for (Ball ball : balls) {
            if (!ball.isEaten() && CollisionDetector.collisionDetector(playerObject, ball)) {
                if (ball.isSpecial()) {
                    superSaiyajin = true;
                    System.out.println("supersayajin" + superSaiyajin);
                }
                ball.delete();
                ball.setEaten(true);
                ballsRemaining--;
                scoreText.setText(String.valueOf(ballsRemaining));
            }
        }
        ghostCollision();
    }

    public void startMenu() {

        menuBackGround.setColor(Color.BLACK);
        menuBackGround.fill();

        button.draw();


    }


    public void gameOverScreen() throws InterruptedException {
        menuBackGround.setColor(Color.BLACK);
        menuBackGround.fill();

        Picture gameOver = new Picture(130, 130, "src/img_2.png");
        gameOver.draw();
        Thread.sleep(1000);
        gameOver.delete();
        menuBackGround.delete();
        System.exit(0);


    }

    private void closeMenu() {
        menuBackGround.delete();
        System.out.println(startGameKey);
        button.delete();
    }


    public void startGame(int speedMillis) throws InterruptedException {

        while (!isGameOver) {

            //If player move doesn't result in a true move (ex: hitting a wall), player maintains direction (currentKey is maintained)
            if (!movePlayer(currentKey)) {
                movePlayer(currentKey);
            }
            for (GhostObject g : ghosts) {
                g.setPicture("src/Untitled-1.png");
            }
            // GhostDoor opening logic

            if (ghostDoorCounterTimer == 30) {
                ghostDoor.translate(40, 0);

            }
            /*if (ghostDoorCounterTimer > 34) {
                for (GhostObject g : ghosts) {

                    if (CollisionDetector.collisionDetector(ghostDoor, g)) {
                        break;
                    }
                }
                ghostDoorCounterTimer = 0;
                //ghostDoor.translate(-40, 0);

            }*/


            for (int i = 0; i < ghosts.size(); i++) {
                LinkedList<Integer> directionsPossible = new LinkedList<>();
                //CheckRight
                ghostMoveCheckers.get(i).translate(5, 0);
                if (wallsCollisionDetector(ghostMoveCheckers.get(i))) {
                    if (ghosts.get(i).lastMove != 0) {
                        directionsPossible.add(0);
                    }
                }
                ghostMoveCheckers.get(i).translate(-5, 0);
                //Check Left
                ghostMoveCheckers.get(i).translate(-5, 0);
                if (wallsCollisionDetector(ghostMoveCheckers.get(i))) {
                    if (ghosts.get(i).lastMove != 1) {
                        directionsPossible.add(1);
                    }
                }
                ghostMoveCheckers.get(i).translate(5, 0);
                //Check Up
                ghostMoveCheckers.get(i).translate(0, -5);
                if (wallsCollisionDetector(ghostMoveCheckers.get(i))) {
                    if (ghosts.get(i).lastMove != 2) {
                        directionsPossible.add(2);
                    }
                }
                ghostMoveCheckers.get(i).translate(0, 5);
                //Check Down
                ghostMoveCheckers.get(i).translate(0, 5);
                if (wallsCollisionDetector(ghostMoveCheckers.get(i))) {
                    if (ghosts.get(i).lastMove != 3) {
                        directionsPossible.add(3);
                    }
                }
                ghostMoveCheckers.get(i).translate(0, -5);


                int direction = 0;
                int rdn = (int) (Math.random() * directionsPossible.size());
                direction = directionsPossible.get(rdn);
                moveGhost(direction, i);
                //Inverts LastMove so Ghost doesn't go back;
                switch (direction) {
                    case 0:
                        ghosts.get(i).lastMove = 1;
                        break;
                    case 1:
                        ghosts.get(i).lastMove = 0;
                        break;
                    case 2:
                        ghosts.get(i).lastMove = 3;
                        break;
                    case 3:
                        ghosts.get(i).lastMove = 2;
                        break;
                }

            }
            ghostCollision();
            ghostDoorCounterTimer++;
            Thread.sleep(speedMillis);
            for (GhostObject g : ghosts) {
                g.setPicture("src/Untitled-2.png");
            }
            playerObject.setPicture("src/pacmanClosed.png");
            Thread.sleep(speedMillis);
        }

    }

    private void ghostCollision() throws InterruptedException {
        for (GhostObject ghost : ghosts) {
            if (CollisionDetector.collisionDetector(ghost, playerObject)) {
                if (!superSaiyajin) {
                    isGameOver = true;
                    Thread.sleep(500);
                    if (lifePlayer > 0) {
                        losesLife();
                    } else {
                        gameOverScreen();
                    }
                } else {

                    ghostMoveCheckers.remove(ghostMoveCheckers.get(ghosts.indexOf(ghost)));
                    ghosts.remove(ghost);
                    ghostMoveCheckers.add(new RectagleObject(375, 340, 30, 30));
                    ghostMoveCheckers.getLast().fill();
                    ghosts.add(new GhostObject(375, 340, 30, 30));
                    ghosts.getLast().draw();

                }
            }


        }
    }

    public boolean wallsCollisionDetector(GameObjects object) {
        arrayCD = new Boolean[wallObjects.size()];
        for (int i = 0; i < wallObjects.size(); i++) {
            arrayCD[i] = CollisionDetector.collisionDetector(object, wallObjects.get(i));
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

        KeyboardEvent rightArrowR = new KeyboardEvent();
        rightArrowR.setKey(KeyboardEvent.KEY_RIGHT);
        rightArrowR.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent leftArrowR = new KeyboardEvent();
        leftArrowR.setKey(KeyboardEvent.KEY_LEFT);
        leftArrowR.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent upArrowR = new KeyboardEvent();
        upArrowR.setKey(KeyboardEvent.KEY_UP);
        upArrowR.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent downArrowR = new KeyboardEvent();
        downArrowR.setKey(KeyboardEvent.KEY_DOWN);
        downArrowR.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent enter = new KeyboardEvent();
        enter.setKey(KeyboardEvent.KEY_ENTER);
        enter.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        //Associate event to keyboard

        keyboard.addEventListener(rightArrow);
        keyboard.addEventListener(leftArrow);
        keyboard.addEventListener(upArrow);
        keyboard.addEventListener(downArrow);
        keyboard.addEventListener(rightArrowR);
        keyboard.addEventListener(leftArrowR);
        keyboard.addEventListener(upArrowR);
        keyboard.addEventListener(downArrowR);
        keyboard.addEventListener(enter);

    }

    public void startBackground() {
        wallObjects.add(new RectagleObject(60, 60, 100, 65));
        wallObjects.add(new RectagleObject(200, 60, 135, 65));
        wallObjects.add(new RectagleObject(445, 60, 135, 65));
        wallObjects.add(new RectagleObject(620, 60, 100, 65));
        wallObjects.add(new RectagleObject(60, 165, 100, 30));
        wallObjects.add(new RectagleObject(620, 165, 100, 30));
        wallObjects.add(new RectagleObject(200, 165, 30, 170));
        wallObjects.add(new RectagleObject(550, 165, 30, 170));
        wallObjects.add(new RectagleObject(230, 235, 105, 30));
        wallObjects.add(new RectagleObject(445, 235, 105, 30));
        wallObjects.add(new RectagleObject(375, 165, 30, 100));
        wallObjects.add(new RectagleObject(270, 165, 240, 30));
        wallObjects.add(new RectagleObject(375, 480, 30, 100));
        wallObjects.add(new RectagleObject(270, 480, 240, 30));
        wallObjects.add(new RectagleObject(375, 620, 30, 100));
        wallObjects.add(new RectagleObject(270, 620, 240, 30));
        wallObjects.add(new RectagleObject(20, 235, 140, 275));
        wallObjects.add(new RectagleObject(620, 235, 140, 275));
        wallObjects.add(new RectagleObject(200, 375, 30, 135));
        wallObjects.add(new RectagleObject(550, 375, 30, 135));
        wallObjects.add(new RectagleObject(200, 550, 135, 30));
        wallObjects.add(new RectagleObject(445, 550, 135, 30));
        wallObjects.add(new RectagleObject(60, 550, 100, 30));
        wallObjects.add(new RectagleObject(620, 550, 100, 30));
        wallObjects.add(new RectagleObject(130, 580, 30, 70));
        wallObjects.add(new RectagleObject(620, 580, 30, 70));
        wallObjects.add(new RectagleObject(20, 620, 70, 30));
        wallObjects.add(new RectagleObject(690, 620, 70, 30));
        wallObjects.add(new RectagleObject(200, 620, 30, 70));
        wallObjects.add(new RectagleObject(550, 620, 30, 70));
        wallObjects.add(new RectagleObject(60, 690, 275, 30));
        wallObjects.add(new RectagleObject(445, 690, 275, 30));
        wallObjects.add(new RectagleObject(270, 305, 30, 135));
        wallObjects.add(new RectagleObject(480, 305, 30, 135));
        wallObjects.add(new RectagleObject(270, 305, 100, 30));
        wallObjects.add(new RectagleObject(410, 305, 100, 30));
        wallObjects.add(new RectagleObject(270, 410, 240, 30));
        wallObjects.add(new RectagleObject(375, 10, 30, 115));
        wallObjects.add(new RectagleObject(10, 10, 760, 10));
        wallObjects.add(new RectagleObject(10, 10, 10, 760));
        wallObjects.add(new RectagleObject(760, 10, 10, 760));
        wallObjects.add(new RectagleObject(10, 760, 760, 10));
        for (int i = 0; i < wallObjects.size(); i++) {
            wallObjects.get(i).setColor(Color.BLUE);
            wallObjects.get(i).draw();

        }
        //GhostDoor


    }

    public void startGhostDoor() {
        wallObjects.add(new RectagleObject(370, 305, 40, 30));
        ghostDoor = wallObjects.getLast();
        ghostDoor.setColor(Color.WHITE);
        ghostDoor.fill();
    }

    public void startText() {
        scoreText = new Text(85, 345, String.valueOf(ballsRemaining));
        scoreText.setColor(Color.WHITE);
        scoreText.grow(30, 20);
        scoreText.draw();
        Text left = new Text(82, 300, "LEFT");
        left.setColor(Color.WHITE);
        left.grow(20, 15);
        left.draw();
        Text score = new Text(85, 270, "BALLS");
        score.setColor(Color.WHITE);
        score.grow(30, 15);
        score.draw();
        scoreTextLives = new Text(675, 345, String.valueOf(lifePlayer));
        scoreTextLives.setColor(Color.WHITE);
        scoreTextLives.grow(30, 20);
        scoreTextLives.draw();
        Text right = new Text(675, 300, "LIVES");
        right.setColor(Color.WHITE);
        right.grow(20, 15);
        right.draw();
        pacman1 = new Picture(650, 390, "src/pacman-png-25195.png");
        pacman2 = new Picture(680, 390, "src/pacman-png-25195.png");
        pacman3 = new Picture(710, 390, "src/pacman-png-25195.png");

        pacman1.draw();
        pacman2.draw();
        pacman3.draw();

    }


    public void startGhosts() {
        for (int i = 0; i < 10; i++) {
            ghostMoveCheckers.add(new RectagleObject(375, 340, 30, 30));
            ghostMoveCheckers.get(i).fill();
        }
        for (int i = 0; i < 10; i++) {
            ghosts.add(new GhostObject(375, 340, 30, 30));
            ghosts.get(i).draw();
        }
    }

    public void startBalls() {
        int l = 0;
        for (int j = 1; j < 22; j++) {
            for (int i = 0; i < 21; i++) {
                double rdm = Math.random() * 10;
                if ((rdm > 9.5) && counterbolinhas <= 5) {
                    balls[l] = new Ball(35 + (i * 35) - 4, 35 * j - 3, 15, 15);
                    balls[l].setSpecial();
                    balls[l].setColor(Color.GREEN);
                    counterbolinhas++;
                } else {
                    balls[l] = new Ball(35 + (i * 35), 35 * j, 5, 5);
                    balls[l].setColor(Color.YELLOW);
                }
                if (CollisionDetector.collisionDetector(playerObject, balls[l])) {
                    balls[l].setEaten(true);
                }
                RectagleObject centre = new RectagleObject(270, 305, 240, 135);

                if (wallsCollisionDetector(balls[l]) && !CollisionDetector.collisionDetector(playerObject, balls[l]) && !CollisionDetector.collisionDetector(centre, balls[l])) {

                    balls[l].fill();
                    ballsRemaining++;
                }
                l++;
            }
        }
    }

    public void losesLife() throws InterruptedException {
        lifePlayer--;
        playerObject = new PlayerObject(25, 25, 30, 30);
        playerObject.draw();
        moveChecker = new RectagleObject(25, 25, 30, 30);
        for (GhostObject g : ghosts) {
            g.delete();
            scoreTextLives.setText(String.valueOf(lifePlayer));
        }
        ghosts.clear();
        ghostMoveCheckers.clear();
        startGhosts();
        isGameOver = false;

        if (lifePlayer == 2) {
            pacman1.delete();
            System.out.println("Tchau");
        }
        if (lifePlayer == 1) {
            pacman2.delete();
            System.out.println("oi");
        }
        if (lifePlayer == 0) {
            pacman3.delete();
            System.out.println("132");
        }

        startGame(125);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if (!isGameOver) {
            switch (keyboardEvent.getKey()) {
                case KeyboardEvent.KEY_RIGHT:
                    currentKey = 0;
                    break;
                case KeyboardEvent.KEY_LEFT:
                    currentKey = 1;
                    break;
                case KeyboardEvent.KEY_UP:
                    currentKey = 2;
                    break;
                case KeyboardEvent.KEY_DOWN:
                    currentKey = 3;
                    break;
                case KeyboardEvent.KEY_ENTER:
                    isGameOver = false;
                    closeMenu();
                    break;
            }

        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        if (!isGameOver) {
            switch (keyboardEvent.getKey()) {
                case KeyboardEvent.KEY_RIGHT:
                    currentKey = 0;
                    break;
                case KeyboardEvent.KEY_LEFT:
                    currentKey = 1;
                    break;
                case KeyboardEvent.KEY_UP:
                    currentKey = 2;
                    break;
                case KeyboardEvent.KEY_DOWN:
                    currentKey = 3;
                    break;
            }

        }
    }

}


