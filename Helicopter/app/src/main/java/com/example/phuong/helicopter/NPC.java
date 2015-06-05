package com.example.phuong.helicopter;

import android.graphics.Bitmap;

/**
 * Created by Phuong on 28/05/2015.
 */
public class NPC extends Enemy {
    private int speed;
    private int position;
    public NPC(int w, int h, int positionY, int positionX) {
        super(w, h);
        this.y = positionY;
        this.x = positionX;
        this.position = positionY/160;
        this.dissapear = true;
    }
    @Override
    public void initSprites(Bitmap res, int numFrames) {
        Bitmap[] images = new Bitmap[numFrames];
        spritesheet = res;
        for (int i=0; i<images.length; i++) {
            images[i] = Bitmap.createBitmap(spritesheet, i*width, 0, width, height);
        }

        animate.setFrames(images);
        animate.setDelay(20);
        startTime = System.nanoTime();
    }
    @Override
    public void update(GamePanel gamePanel) {
        x -= speed;
        animate.update();
    }

    public int getPosition() {
        return position;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }
}
