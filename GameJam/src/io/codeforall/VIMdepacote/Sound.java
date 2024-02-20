package io.codeforall.VIMdepacote;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Sound {
    private Clip clip;
    URL songUrl;

    public Sound(String filePath) {
        songUrl = getClass().getResource(filePath);

        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(songUrl);
            System.out.println(audioInputStream);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (UnsupportedAudioFileException | LineUnavailableException e) {
            throw new RuntimeException(e);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }}


        public void play() {
            if (clip != null) {
                clip.setFramePosition(0);
                clip.start();
            }
        }


        public void stop () {
            if (clip != null) {
                clip.stop();
            }
        }
        public void close () {
            if (clip != null) {
                clip.close();
            }
        }

    }



























