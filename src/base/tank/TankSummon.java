package base.tank;

import base.GameObject;
import base.Settings;
import base.action.Action;
import base.action.ActionRepeat;
import base.action.ActionSequence;
import base.action.ActionWait;

public class TankSummon extends GameObject {
    Action action;
    public boolean isEnd;

    public TankSummon() {
        taoTank();
    }

    public void taoTank() {
        isEnd=false;
        ActionWait actionWait = new ActionWait(50);
        Action actionFire = new Action() {
            @Override
            public void run(GameObject master) {
                taoTanks();
                this.isDone = true;
            }

            @Override
            public void reset() {
                this.isDone = false;
            }

        };
        ActionSequence actionSequence = new ActionSequence(actionWait, actionFire);
        ActionRepeat actionRepeat = new ActionRepeat(actionSequence);
        this.action = actionRepeat;
    }

    public void taoTanks() {
                TankType1 tankType1 = GameObject.recycle(TankType1.class);
                tankType1.position.set(Settings.TANK_POSITION_X-20, Settings.TANK_POSITION_Y +10 );

                TankType2 tankType2 = GameObject.recycle(TankType2.class);
                tankType2.position.set(Settings.SCREEN_WIDHT-50, Settings.TANK_POSITION_Y-100);
        }
    @Override
    public void run() {
        if (!isEnd)this.action.run(this);
    }
}
