package base.enemy;

import base.*;
import base.physics.BoxCollider;
import base.physics.Physics;
import base.player.Player;
import base.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

public class EnemyBullet extends GameObject implements Physics {

    Vector2D velocity;
    int damage;

    public EnemyBullet() {
        this.renderer = new SingleImageRenderer(SpriteUtils.loadImage("assets/images/enemy-bullets/0.png"));
        //this.position = new Vector2D(0, 0);
        this.collider = new BoxCollider(12, 20);
        this.velocity = new Vector2D(0, 9);
        this.damage = 1;
    }

    @Override
    public void run() {
        this.position.addThis(this.velocity);
        Player player = GameObject.intersect(Player.class, this);
        if(player != null) {
            player.takeDamage(this.damage);
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
