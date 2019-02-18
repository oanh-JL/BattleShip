package base.enemy.enemyboss;

import base.Explosion;
import base.GameObject;
import base.Vector2D;
import base.physics.BoxCollider;
import base.physics.Physics;
import base.player.Player;
import base.renderer.AnimationRenderer;
import base.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class EnemyBossBullet extends GameObject implements Physics {
    BoxCollider collider;
    Vector2D velocity;
    int damage;

    public EnemyBossBullet() {
        this.renderer = new SingleImageRenderer(SpriteUtils.loadImage("assets/images/boss/0.png"));
        this.position = new Vector2D(0, 0);
        this.collider = new BoxCollider(20, 32);
        this.velocity = new Vector2D(0, 10);
        this.damage = 4;
    }

    @Override
    public void run() {
        this.position.addThis(this.velocity.x, this.velocity.y);
        Player player = GameObject.intersect(Player.class, this);
        if(player != null) {
            player.takeDamageByBoss(this.damage);
            this.destroy();
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        Explosion explosion = GameObject.recycle(Explosion.class);
        explosion.position.set(this.position.x,this.position.y);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.collider;
    }
}
