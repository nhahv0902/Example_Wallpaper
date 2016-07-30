package com.nhahv.examplewallpaper;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by Nhahv on 7/30/2016.
 * <></>
 */

public class Text {


    public static final int LEFT = 1;
    public static final int RIGHT = 2;
    public static final int UP = 3;
    public static final int DOWN = 4;


    private String text;
    private int x, y;
    private int color;
    private int size;
    private int orient;
    private int widthText;
    private int heightText;


    public Text() {
    }

    public Text(String text, int x, int y, int color, int size, int orient) {
        this.text = text;
        this.x = x;
        this.y = y;
        this.color = color;
        this.size = size;
        this.orient = orient;

        Paint paint = new Paint();
        paint.setTextSize(size);
        Rect rectSize = new Rect();
        paint.getTextBounds(text, 0, text.length(), rectSize);
        widthText = rectSize.width();
        heightText = rectSize.height();

    }

    public void draw(Canvas canvas, Paint paint) {
        paint.setColor(color);
        paint.setTextSize(size);
        canvas.drawText(text, x, y, paint);
    }

    public void move(int wScreen, int hScreen) {
        switch (orient) {
            case LEFT:
                x--;
                if (x < -widthText) {
                    x = wScreen;
                }
                break;
            case RIGHT:
                x++;
                if (x > wScreen) {
                    x = widthText;
                }
                break;
            case UP:
                y--;
                if (y < -heightText) {
                    y = hScreen;
                }
                break;
            case DOWN:
                y++;
                if (y > hScreen) {
                    y = -heightText;
                }
                break;
            default:
                break;

        }
    }
}
