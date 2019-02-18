package base.scene.gamewinscene;

import base.GameObject;
import base.Settings;
import base.event.KeyEventPress;
import base.renderer.SingleImageRenderer;
import base.scene.SceneManager;
import base.scene.SceneStage1;
import tklibs.SpriteUtils;

public class BannerWinScene extends GameObject {
    public BannerWinScene(){
        super();
        this.renderer = new SingleImageRenderer(SpriteUtils.loadImage("assets/images/background/GameWinScene.png"));
        this.position.set(Settings.SCREEN_WIDHT/2, Settings.SCREEN_HEIGHT/2);
    }

    @Override
    public void run() {
        if (KeyEventPress.isEnterPress){
            SceneManager.signNewScene(new SceneStage1());
        }
    }
}
