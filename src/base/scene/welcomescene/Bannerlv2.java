package base.scene.welcomescene;

import base.GameObject;
import base.Settings;
import base.event.KeyEventPress;
import base.renderer.SingleImageRenderer;
import base.scene.SceneManager;
import base.scene.SceneStage2;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class Bannerlv2 extends GameObject {
    public Bannerlv2(){
        super();
        BufferedImage image = SpriteUtils.loadImage("assets/images/scenes/level2.png");
        this.renderer = new SingleImageRenderer(image);
        this.position.set(Settings.SCREEN_WIDHT/2, Settings.SCREEN_HEIGHT/2);
    }
    @Override
    public void run() {
        if (KeyEventPress.isEnterPress){
            SceneManager.signNewScene(new SceneStage2());
        }
    }
}
