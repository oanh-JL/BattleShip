package base.scene;

import base.BackgroundStone;
import base.GameObject;
import base.player.Player;
import base.stone.StoneSummon;

public class SceneStage2 extends Scene {

    public BackgroundStone backgroundStone;
    public Player player;
    StoneSummon stoneSummon;

    @Override
    public void destroy() {
        GameObject.clearAll();
    }

    @Override
    public void init() {
        this.backgroundStone = GameObject.recycle(BackgroundStone.class);
        this.player = GameObject.recycle(Player.class);
        stoneSummon= GameObject.recycle(StoneSummon.class);
    }
    @Override
    public void run() {
        super.run();
        stoneSummon.isEnd = backgroundStone.isEnd;
    }
}
