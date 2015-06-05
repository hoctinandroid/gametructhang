package com.example.phuong.helicopter;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import java.util.Random;

/**
 * Created by Phuong on 01/05/2015.
 */
public class Enemy extends Player{
    protected int HealthPoints;
    protected int HealthPointsPool;
    protected long delay;
    protected Random rd = new Random();
    public Enemy(int w, int h) {
        super(w, h);
        up = rd.nextBoolean();
        delay = 0;
        this.HealthPoints = 0;
        this.HealthPointsPool = 0;
    }

    public void initSprites(Bitmap[] res) {
        animate.setFrames(res);
        animate.setDelay(10);
        startTime = System.nanoTime();
    }

    @Override
    public void update(GamePanel gamePanel) {
        if(delay > 0){
           if((System.nanoTime() - delay)/1000000 > 1000) delay = 0;
        }
        else{
            if(up){
                y -= 10;
            }
            else{
                y += 10;
            }
            if(y > gamePanel.getHeight() - height - 80){
                y = gamePanel.getHeight() - height - 80;
                up = rd.nextBoolean();
            }
            if(y < 30){
                y = 30;
                up = rd.nextBoolean();
            }
            if(rd.nextInt(4) == 1){
                delay = System.nanoTime();
            }
        }
        animate.update();
    }

    public int getHealthPoints() {
        return HealthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        HealthPoints = healthPoints;
    }

    public int getHealthPointsPool() {
        return HealthPointsPool;
    }

    public void setHealthPointsPool(int healthPointsPool) {
        HealthPointsPool = healthPointsPool;
    }

    public float getPecentagesOfHP(){
        return ((float) this.HealthPoints)/((float) this.HealthPointsPool);
    }
}
