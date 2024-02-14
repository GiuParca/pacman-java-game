package io.codeforall.VIMdepacote;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Ball extends GameObjects {

    private Ellipse ball;

    private boolean isEaten;
    private boolean isSpecial;

    public Ball(double initX, double initY, double width, double height) {
        super();
        this.ball = new Ellipse(initX, initY,width,height);
        double right = ball.getX() + ball.getWidth();
        double bottom = ball.getY() + ball.getHeight();
        double left = ball.getX();
        double up = ball.getY();
        setObjectBounds(right, up, left, bottom);
        this.setColor(Color.BLACK);

    }

    public void fill() {
        this.ball.fill();
    }

    public void delete(){
        this.ball.delete();
    }

    public void setColor(Color color) {
        this.ball.setColor(color);
    }

    public void setSpecial() {
        isSpecial = true;
    }

    public boolean isSpecial() {
        return isSpecial;
    }

    public void setEaten(boolean eaten) {
        isEaten = eaten;
    }

    public boolean isEaten() {
        return isEaten;
    }

    public Ellipse getBall(){
        return this.ball;
    }
}
