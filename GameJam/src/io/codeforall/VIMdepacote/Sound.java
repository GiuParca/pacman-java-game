package io.codeforall.VIMdepacote;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Sound {
    private Clip jaws;

    public Sound() {
        try {
            File soundFile = new File("src/io/codeforall/VIMdepacote/PacmanMusic.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            jaws = AudioSystem.getClip();
            jaws.open(audioInputStream);

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

}



























