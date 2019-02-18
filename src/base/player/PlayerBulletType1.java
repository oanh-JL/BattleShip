package base.player;

import base.Explosion;
import base.GameObject;
import base.enemy.EnemyBullet;
import base.physics.BoxCollider;
import base.renderer.SingleImageRenderer;

public class PlayerBulletType1 extends PlayerBullet {
    public PlayerBulletType1() {
        super();
        this.renderer = new SingleImageRenderer("assets/images/enemy-bullets/2.png");
        this.collider = new BoxCollider(15, 15);
        this.damage = 1;
    }

    @Override
    public void hitEnemy() {
        this.destroy();
    }
    @Override
    public void destroy() {
        super.destroy();
        Explosion explosion = GameObject.recycle(Explosion.class);
        explosion.position.set(this.position);
    }

    @Override
    public void hitBoss(){
        this.destroy();
    }

    @Override
    public BoxCollider getBoxCollider() {
        return super.getBoxCollider();
    }
}
