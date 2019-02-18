package base.scene;

import base.Background;
import base.BackgroundGun;
import base.GameObject;
import base.counter.FrameCounter;
import base.enemy.EnemySummoner;
import base.player.Player;
import base.scene.gameoverscene.GameOverScene;
import base.tank.Tank;
import base.tank.TankSummon;
import javafx.scene.media.MediaPlayer;
import tklibs.AudioUtils;

public class SceneStage1 extends Scene {

    public BackgroundGun backgroundGun;
    public Player player;
    TankSummon tankSummon;


    @Override
    public void destroy() {
        GameObject.clearAll();

    }

    @Override
    public void init() {
//        AudioUtils.initialize();
//        MediaPlayer mediaPlayer = AudioUtils.playMedia("assets/Sound/background.mp3");
//        mediaPlayer.play();
        this.backgroundGun = GameObject.recycle(BackgroundGun.class);
        this.player = GameObject.recycle(Player.class);
        tankSummon = GameObject.recycle(TankSummon.class);
    }

    @Override
    public void run() {
        super.run();
        tankSummon.isEnd = backgroundGun.isEnd;

    }
}
