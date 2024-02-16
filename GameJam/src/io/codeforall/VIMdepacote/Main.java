package io.codeforall.VIMdepacote;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Sound sound = new Sound();
        sound.play();
        //sound.play();
        Game game = new Game();
        //game.startCD();
        //game.start();
        game.startMenu();
        game.startGame(125);




    }
}