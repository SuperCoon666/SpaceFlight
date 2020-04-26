package com.example.spaceflight;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;

public class Stars {
    public Stars() {
        for (int i = 0; i < 100; i++) {
            stars.add(new Star());
        }
    }

    Paint p = new Paint();
    ArrayList<Star> stars = new ArrayList<>();
    public void draw(Canvas c) {
        float w = c.getWidth();
        float h = c.getHeight();
        for (Star s: stars) {
            p.setColor(s.color);
            c.drawCircle(s.getX()*w + w/2  , s.getY()*h + h/2,
                    (float)Math.abs(Math.sqrt(s.getX()*s.getX() + s.getY()*s.getY())) * 20, p);
        }

    }
    public void moveStars() {
        for (Star s: stars) {
            s.move();
            if (Math.abs(s.getX()) > 1 || Math.abs(s.getY()) > 1) {
                s.reset();
            }
        }
    }
}
