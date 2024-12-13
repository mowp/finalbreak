package io.github.mowpBreakout;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
public class player {
    private int x, y, w, h, isMoving, vel, isHit, isHitPwr;

    public player(int x, int y, int w, int h, int isMoving, int vel, int isHit, int isHitPwr) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.isMoving = isMoving;
        this.vel = vel;
        this.isHit = isHit;
        this.isHitPwr = isHitPwr;
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

    public int getIsMoving() {
        return isMoving;
    }

    public void setIsMoving(int isMoving) {
        this.isMoving = isMoving;
    }

    public int getVel() {
        return vel;
    }

    public void setVel(int vel) {
        this.vel = vel;
    }

    public int getIsHit() {
        return isHit;
    }

    public void setIsHit(int isHit) {
        this.isHit = isHit;
    }

    public int getIsHitPwr() {
        return isHitPwr;
    }

    public void setIsHitPwr(int isHitPwr) {
        this.isHitPwr = isHitPwr;
    }

    public void draw(ShapeRenderer sR) {
        sR.setColor((Color.BLACK));
        sR.rect(x,y,w,h);
    }
}
