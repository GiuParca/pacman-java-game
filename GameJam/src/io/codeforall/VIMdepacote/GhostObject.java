package io.codeforall.VIMdepacote;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GhostObject extends GameObjects {

    private Picture picture;
    int lastMove;
    private boolean isEatable;



    public GhostObject(double initX, double initY, double width, double height) {
        super();
        this.picture = new Picture(initX, initY,"src/Untitled-1.png");
        double right = picture.getX() + picture.getWidth();
        double bottom = picture.getY() + picture.getHeight();
        double left = picture.getX();
        double up = picture.getY();
        setObjectBounds(right, up, left, bottom);
        lastMove = 2;

    }


    public boolean isEatable() {
        return isEatable;
    }

    public void setEatable(boolean eatable) {
        isEatable = eatable;
    }

    public void delete(){
        this.picture.delete();
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
