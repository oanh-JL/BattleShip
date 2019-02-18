package base.scene;

import base.Background;
import base.GameObject;
import base.counter.FrameCounter;
import base.enemy.EnemySummoner;
import base.player.Player;
import base.scene.gameoverscene.GameOverScene;
import base.scene.gamewinscene.GameWinScene;
import base.stone.StoneSummon;

public abstract class Scene {
    FrameCounter frameCounter = new FrameCounter(200);

    public abstract void destroy();

    public abstract void init();

    public void run() {
       // System.out.println(GameObject.playerIsDead);
        if (GameObject.playerIsDead) {
            if (frameCounter.run()) {
                SceneManager.signNewScene(new GameOverScene());
                frameCounter.reset();
            }
        }
        if (GameObject.bossIsDead) {
            if (frameCounter.run()) {
                SceneManager.signNewScene(new GameWinScene());
                frameCounter.reset();
            }
        }
    }
}
