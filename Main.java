package io.github.mowpBreakout;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import java.lang.Math;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    private ShapeRenderer sR;

    int playerSpeed;
    int ballSpeed;
    int spacer = 64+16;
    player player;
    Ball ball;
    Enemy[] enemies;

    @Override
    public void create() {
        sR = new ShapeRenderer();
        player = new player(0,0,100,25,0,0,0,0);
        player.setVel(0);
        player.setIsMoving(0);
        playerSpeed = 10;

        ball = new Ball(player.getX()+player.getW()/2,player.getY()+player.getH(),5,0,0,1,0);
        ballSpeed = 5;
        ball.setIsShot(0);
        ball.setDy(ballSpeed);

        enemies = new Enemy[20];
        for(int i=0; i<enemies.length; i++){
            enemies[i] = new Enemy(8+i*spacer,Gdx.graphics.getHeight()-16,64,16,1,0);
            if (i>6 && i<12){
                for(int j=0; j<enemies.length-i; j++){
                    enemies[i] = new Enemy(8+j*spacer,Gdx.graphics.getHeight()-64,64,16,1,0);
                }
            }
            if (i>12){
                for(int k=0; k<enemies.length-i; k++){
                    enemies[i] = new Enemy(8+k*spacer,Gdx.graphics.getHeight()-112,64,16,1,0);
                }
            }
        }

    }

    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);

        //player movement
        if (Gdx.input.isKeyPressed(Input.Keys.A) && player.getX() > 0) {
            player.setVel(-10);
            player.setX(player.getX() + player.getVel());
        }

        if (Gdx.input.isKeyPressed(Input.Keys.D) && player.getX() + player.getW() < Gdx.graphics.getWidth()) {
            player.setVel(10);
            player.setX(player.getX() + player.getVel());
        }
        if (!Gdx.input.isKeyPressed(Input.Keys.D) && !Gdx.input.isKeyPressed(Input.Keys.A)) {
            player.setVel(0);
        }

        //ball movement
        if (ball.getIsAlive() == 0) {
            ball.setIsShot(0);
            ball.setIsAlive(1);
        }

        if (ball.getIsShot() == 0 && ball.getIsAlive() == 1) {
            ball.setY(player.getY()+player.getH());
            ball.setX(player.getX()+player.getW()/2);
        }

        if (ball.getIsAlive() == 1 && ball.getIsShot() == 1) {
            ball.setY(ball.getY()+ball.getDy());
            ball.setX(ball.getX()+ball.getDx());
        }

        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            if (player.getVel() == -10 && ball.getIsShot() == 0) {
                ball.setDx(ballSpeed*-1);
            }
            if (player.getVel() == 10 && ball.getIsShot() == 0) {
                ball.setDx(ballSpeed);
            }
            if (player.getVel() == 0 && ball.getIsShot() == 0) {
                ball.setDx(0);
            }

            ball.setIsShot(1);

        }


        if (ball.getY()+ball.getRad()>Gdx.graphics.getHeight() && ball.getIsAlive() == 1) {
            ball.setDy(ball.getDy()*-1);
            //ball.setIsAlive(0);
            System.out.println("ball roof");
        }

        if (ball.getX() - ball.getRad() <= 0 && ball.getIsShot() == 1) {
            System.out.println("bounce off left");
            ball.setDx(ball.getDx()*-1);
            //ball.setIsAlive(0);
        }
        if (ball.getX() + ball.getRad() >= Gdx.graphics.getWidth() && ball.getIsShot() == 1) {
            System.out.println("bounce off right");
            ball.setDx(ball.getDx()*-1);
            //ball.setIsAlive(0);
        }

        //ball hit enemies
        for (int i=0; i< enemies.length; i++) {
            if (ball.getX() - ball.getRad() > enemies[i].getX() && ball.getX() + ball.getRad() < enemies[i].getX() + enemies[i].getW() && enemies[i].getHealth()>0) {
                if (ball.getY() + ball.getRad() > enemies[i].getY() && ball.getY() + ball.getRad() < enemies[i].getY() + enemies[i].getH()) {
                    System.out.println("hit enemy: " + i);
                    enemies[i].setHealth(enemies[i].getHealth()-1);
                    //ball.setIsAlive(0);
                    ball.setDy(ball.getDy()*-1);
                }
            }
        }

        //ball hit player
        if (ball.getX() - ball.getRad() > player.getX() && ball.getX() + ball.getRad() < player.getX() + player.getW()) {
            if(ball.getY() - ball.getRad() > player.getY() && ball.getY() + ball.getRad() < player.getY() + player.getH()) {
                System.out.println("hit playerr");
                if (player.getVel() == -10) {
                    ball.setDx(ballSpeed*-1);
                }
                if (player.getVel() == 10) {
                    ball.setDx(ballSpeed);
                }
                ball.setDy(ball.getDy()*-1);
            }
        }

        // render
        sR.begin(ShapeRenderer.ShapeType.Filled);
        player.draw(sR);
        ball.draw(sR);
        for (int i=0; i < enemies.length; i++) {
            enemies[i].draw(sR);
        }
        sR.end();
    }



    @Override
    public void dispose() {
    }
}
