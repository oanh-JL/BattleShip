package base.player;

import base.GameObject;
import base.renderer.SingleImageRenderer;


public class DeathPlayer extends GameObject {
    public DeathPlayer() {
        super();
        this.renderer = new SingleImageRenderer("assets/images/players/explosion/0.png");
    }

}
