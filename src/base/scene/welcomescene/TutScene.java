package base.scene.welcomescene;

import base.GameObject;
import base.scene.Scene;

public class TutScene extends Scene {
    @Override
    public void destroy() {
        GameObject.clearAll();
    }

    @Override
    public void init() {
        GameObject bannerlv1 = GameObject.recycle(BannerTut.class);
    }

    @Override
    public void run() {

    }
}