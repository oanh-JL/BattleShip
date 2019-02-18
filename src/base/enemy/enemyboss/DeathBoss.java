package base.enemy.enemyboss;


import base.GameObject;
import base.renderer.SingleImageRenderer;

public class DeathBoss extends GameObject {
    public DeathBoss(){
        super();
        this.renderer = new SingleImageRenderer("assets/images/boss/bossEx.png");
    }
}
