package io.codeforall.VIMdepacote;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Ball extends GameObjects {

    private Picture ball;

    private boolean isEaten;
    private boolean isSpecial;

    public Ball(double initX, double initY, double width, double height) {
        super();
        this.ball = new Picture(initX, initY,Prefix.prefix + "beer.png");
        double right = ball.getX() + ball.getWidth();
        double bottom = ball.getY() + ball.getHeight();
        double left = ball.getX();
        double up = ball.getY();
        setObjectBounds(right, up, left, bottom);

        /*this.setPicture(Prefix.prefix + "beer.png");*/

    }

    public void fill() {
        this.ball.draw();
    }

    public void delete(){
        this.ball.delete();
    }

    public void setPicture(String picturePath) {
        this.ball.load(picturePath);
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

    /*public Ellipse getBall(){
        return this.ball;
    }*/
}
