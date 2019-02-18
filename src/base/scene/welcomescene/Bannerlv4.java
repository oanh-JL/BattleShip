package base.scene.welcomescene;

import base.GameObject;
import base.Settings;
import base.event.KeyEventPress;
import base.renderer.SingleImageRenderer;
import base.scene.SceneManager;
import base.scene.SceneStage3;
import base.scene.SceneStage4;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class Bannerlv4 extends GameObject {
    public Bannerlv4(){
        super();
        BufferedImage image = SpriteUtils.loadImage("assets/images/scenes/level4.png");
        this.renderer = new SingleImageRenderer(image);
        this.position.set(Settings.SCREEN_WIDHT/2, Settings.SCREEN_HEIGHT/2);
    }
    @Override
    public void run() {
        if (KeyEventPress.isEnterPress){
            SceneManager.signNewScene(new SceneStage4());
        }
    }
}
