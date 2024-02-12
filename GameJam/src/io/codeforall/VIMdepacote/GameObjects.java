package io.codeforall.VIMdepacote;

import org.academiadecodigo.simplegraphics.graphics.Color;

public class GameObjects {

    private Color color;
    private double right;
    private double up;

    private double left;
    private double bottom;


    public void setObjectBounds (double right, double up, double left, double bottom){
        this.right = right;
        this.left = left;
        this.up = up;
        this.bottom = bottom;
    }

    public double getUp() {
        return up;
    }

    public double getRight() {
        return right;
    }

    public double getBottom() {
        return bottom;
    }

    public double getLeft() {
        return left;
    }


}
