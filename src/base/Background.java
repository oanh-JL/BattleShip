package base;

import base.event.KeyEventPress;
import base.renderer.SingleImageRenderer;
import base.scene.SceneManager;
import base.scene.SceneStage2;
import base.scene.welcomescene.Level2Scene;
import base.scene.welcomescene.Level4Scene;
import javafx.scene.media.MediaPlayer;
import tklibs.AudioUtils;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class Background extends GameObject {
    public boolean isEnd = false;

    public Background() {
        super();
        BufferedImage image = SpriteUtils.loadImage("assets/images/background/background.png");
        //MediaPlayer mediaPlayer  = AudioUtils.playMedia("");
        this.renderer = new SingleImageRenderer(image);
        this.position = new Vector2D(0,
                -(image.getHeight() - Settings.SCREEN_HEIGHT));
        this.anchor.set(0, 0);
    }

    @Override
    public void run() {
        if (this.position.y >= 0) {
            //isEnd = true;
            if (this.position.y==0){
                if (KeyEventPress.isAnyKeyPress) {
                    SceneManager.signNewScene(new Level4Scene());
                }
            }
            return;
        } else {
            if (this.position.y > -Settings.SCREEN_HEIGHT - 500) {
                isEnd = true;
            }
            this.position.y += 3/*speed*/;
        }
        //System.out.println(isEnd);
    }
}
