package base.scene.welcomescene;

import base.GameObject;
import base.scene.Scene;

public class Level1Scene extends Scene {
    @Override
    public void destroy() {
       GameObject.clearAll();
    }

    @Override
    public void init() {
        GameObject bannerlv1 = GameObject.recycle(Bannerlv1.class);
    }

    @Override
    public void run() {

    }
}