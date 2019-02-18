package base.scene.welcomescene;

import base.GameObject;
import base.scene.Scene;
import javafx.scene.media.MediaPlayer;
import tklibs.AudioUtils;

public class WelcomeScene extends Scene {
    @Override
    public void destroy() {
        GameObject.clearAll();
    }

    @Override
    public void init() {
        AudioUtils.initialize();
        MediaPlayer mediaPlayer = AudioUtils.playMedia("assets/Sound/background.mp3");
        mediaPlayer.play();
        GameObject banner = GameObject.recycle(Banner.class);

    }

    @Override
    public void run() {

    }
}
