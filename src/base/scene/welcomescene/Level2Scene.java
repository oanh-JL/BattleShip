package base.scene.welcomescene;

import base.GameObject;
import base.scene.Scene;

public class Level2Scene extends Scene {
    @Override
    public void destroy() {
        GameObject.clearAll();
    }

    @Override
    public void init() {
        GameObject bannerlv2 = GameObject.recycle(Bannerlv2.class);
    }

    @Override
    public void run() {
    }
}