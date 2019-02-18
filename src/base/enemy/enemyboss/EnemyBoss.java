package base.enemy.enemyboss;

import base.Explosion;
import base.GameObject;
import base.Vector2D;
import base.action.Action;
import base.action.ActionRepeat;
import base.action.ActionSequence;
import base.action.ActionWait;
import base.counter.FrameCounter;
import base.physics.BoxCollider;
import base.physics.Physics;
import base.player.DeathPlayer;
import base.renderer.SingleImageRenderer;
import base.scene.SceneManager;
import base.scene.gamewinscene.GameWinScene;
import javafx.scene.media.MediaPlayer;
import tklibs.AudioUtils;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class EnemyBoss extends GameObject implements Physics {
    BoxCollider collider;
    int hp;
    Action actionMove;
    Action actionFire;
    FrameCounter fireCounter;
    FrameCounter moveCounter;
    Vector2D velocity;
    public EnemyBoss() {
        super();
        BufferedImage image = SpriteUtils.loadImage("assets/images/boss/1.png");
        this.renderer = new SingleImageRenderer(image);
        this.position = new Vector2D(200, 100);
        this.fireCounter = new FrameCounter(20);
        this.moveCounter = new FrameCounter(30);
        this.collider = new BoxCollider(110, 115);
        this.hp = 30;
        this.velocity = new Vector2D(0, 0);

        this.defineAction();
    }

    void defineAction() {
        ActionWait actionWait = new ActionWait(20);
        Action actionFire = new Action() {
            @Override
            public void run(GameObject master) {
                fire();
                this.isDone = true;
            }

            @Override
            public void reset() {
                this.isDone = false;
            }
        };

        Action actionMove = new Action() {
            @Override
            public void run(GameObject master) {
                move();
                this.isDone = true;
            }

            @Override
            public void reset() {
                this.isDone = false;
            }
        };
        ActionSequence actionSequenceFire = new ActionSequence(actionWait, actionFire);
        ActionRepeat actionRepeatFire = new ActionRepeat(actionSequenceFire);

        ActionSequence actionSequenceMove = new ActionSequence(actionMove);
        ActionRepeat actionRepeatMove = new ActionRepeat(actionSequenceMove);

        this.actionFire = actionRepeatFire;
        this.actionMove = actionRepeatMove;
    }

    @Override
    public void run() {
        this.actionMove.run(this);
        this.actionFire.run(this);
        if (this.position.y > 700) {
            this.destroy();
            return;
        }
    }

    public void fire() {
        EnemyBossBullet bullet = GameObject.recycle(EnemyBossBullet.class);

        bullet.velocity.set(0, 2);

        bullet.position.set(this.position.x, this.position.y + 10);

        this.fireCounter.reset();
    }

    public void move() {
        boolean moveCounterRun = moveCounter.run();
        if (this.position.x<=170){
            this.position.x = 170;
        }
        if (moveCounterRun) {
            this.position.addThis(5, 0);
        } else {
            this.position.addThis(-5, 0);
        }
        if (this.position.x > 350) {
            this.moveCounter.reset();
        }

    }

    @Override
    public void destroy() {
        super.destroy();

        Explosion explosion = GameObject.recycle(Explosion.class);
        explosion.position.set(this.position);

        AudioUtils.initialize();
        MediaPlayer mediaPlayer = AudioUtils.playMedia("assets/Sound/enemy-player-explosion-big.wav");
        mediaPlayer.play();

        DeathBoss deathBoss = GameObject.recycle(DeathBoss.class);
        deathBoss.position.set(this.position);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.collider;
    }

    public void takeDamageByPlayer(int damage) {
        this.hp -= damage;
        if (this.hp <= 0) {
            this.destroy();
           // SceneManager.signNewScene(new GameWinScene());
        }
    }
}