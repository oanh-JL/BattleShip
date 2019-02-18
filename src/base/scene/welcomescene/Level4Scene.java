package base.scene.welcomescene;

import base.GameObject;
import base.scene.Scene;

public class Level4Scene extends Scene {

    @Override
    public void destroy() {
        GameObject.clearAll();
    }

    @Override
    public void init() {
        GameObject bannerlv4 = GameObject.recycle(Bannerlv4.class);
    }

    @Override
    public void run() {

    }
}