package io.github.mowpBreakout;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Ball {
    private int x,y,rad,dy,dx,isAlive,hit,isShot;

    public Ball(int x, int y, int rad, int dy, int dx, int isAlive, int hit) {
        this.x = x;
        this.y = y;
        this.rad = rad;
        this.dy = dy;
        this.dx = dx;
        this.isAlive = isAlive;
        this.hit = hit;
        this.isShot = isShot;
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

    public int getRad() {
        return rad;
    }

    public void setRad(int rad) {
        this.rad = rad;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getIsAlive() {
        return isAlive;
    }

    public void setIsAlive(int isAlive) {
        this.isAlive = isAlive;
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public int getIsShot() {
        return isShot;
    }
    public void setIsShot(int isShot) {
        this.isShot = isShot;
    }


    public void draw(ShapeRenderer sR) {
        if (isAlive == 1) {
            sR.setColor((Color.BLUE));
            sR.circle(x,y,rad);
        }
    }
}
