package io.github.mowpBreakout;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Enemy {
    private int x,y,w,h,health,isHit;

    public Enemy(int x, int y, int w, int h, int health, int isHit) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.health = health;
        this.isHit = isHit;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getIsHit() {
        return isHit;
    }

    public void setIsHit(int isHit) {
        this.isHit = isHit;
    }

    public void draw(ShapeRenderer sR) {
        if (health>0) {
            sR.setColor((Color.GREEN));
            sR.rect(x,y,w,h);
        }
    }
}
