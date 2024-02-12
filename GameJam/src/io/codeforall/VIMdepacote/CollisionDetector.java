package io.codeforall.VIMdepacote;

public class CollisionDetector {


    public static boolean collisionDetector(GameObjects object1, GameObjects object2) {

        return object1.getUp() <= object2.getBottom() && object1.getLeft() <= object2.getRight() && object1.getRight() >= object2.getLeft() && object1.getBottom() >= object2.getUp();
    }

    public static boolean canMove(Boolean[] collisionDetectorArray){
        for (Boolean i : collisionDetectorArray) {
            if (i){
                return false;
            }
        }
        return true;
    }
}
