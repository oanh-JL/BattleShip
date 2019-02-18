package base.scene.welcomescene;

import base.GameObject;
import base.scene.Scene;

public class Level3Scene extends Scene {
    @Override
    public void destroy() {
        GameObject.clearAll();
    }

    @Override
    public void init() {
        GameObject bannerlv3 = GameObject.recycle(Bannerlv3.class);
    }

    @Override
    public void run() {

    }
}