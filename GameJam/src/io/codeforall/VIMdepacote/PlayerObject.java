package io.codeforall.VIMdepacote;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class PlayerObject extends GameObjects {

    private Picture picture;
    int lastMove;


    public PlayerObject(double initX, double initY, double width, double height) {
        super();
        this.picture = new Picture(initX, initY,"src/io/codeforall/VIMdepacote/playerDown.png");
        double right = picture.getX() + picture.getWidth();
        double bottom = picture.getY() + picture.getHeight();
        double left = picture.getX();
        double up = picture.getY();
        setObjectBounds(right, up, left, bottom);
        lastMove = 2;

    }


    public void draw() {
        this.picture.draw();
    }

    public void setPicture(String picturePath) {
        this.picture.load(picturePath);
    }


    public Picture getPicture() {
        return this.picture;
    }

    public void translate(int x, int y) {
        this.picture.translate(x, y);
        double right = picture.getX() + picture.getWidth();
        double bottom = picture.getY() + picture.getHeight();
        double left = picture.getX();
        double up = picture.getY();
        setObjectBounds(right, up, left, bottom);

    }



}
