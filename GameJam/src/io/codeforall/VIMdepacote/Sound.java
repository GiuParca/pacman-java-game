package io.codeforall.VIMdepacote;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Sound {
    private Clip jaws;
    private Clip scream;
    public Sound() {
        try {
            File soundFile = new File("src/io/codeforall/VIMdepacote/PacmanMusic.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            jaws = AudioSystem.getClip();
            jaws.open(audioInputStream);
            /*File screamFile = new File("/Users/codecadet/Desktop/sharkGame/lib/resources/Scream.wav");
            AudioInputStream audioInputScream = AudioSystem.getAudioInputStream(screamFile);
            scream = AudioSystem.getClip();
            scream.open(audioInputScream);*/
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
    public void play() {
        if (jaws != null) {
            jaws.setFramePosition(0);
            jaws.start();
        }
    }
    /*public void loop(int times) {
        if (jaws != null) {
            jaws.loop(times);
        }
    }*/
    public void stop() {
        if (jaws != null) {
            jaws.stop();
        }
    }
    public void close() {
        if (jaws != null) {
            jaws.close();
        }
    }
    public void Scream() {
        if (scream != null) {
            scream.setFramePosition(0);
            scream.start();
        }
    }
}



























