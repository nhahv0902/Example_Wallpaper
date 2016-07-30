package com.nhahv.examplewallpaper;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Nhahv on 7/30/2016.
 * <></>
 */

public class TextManager {

    public static int COUNT_TEXT = 50;

    private List<Text> mListText = new ArrayList<>(COUNT_TEXT);

    public TextManager() {
    }

    public void initListText(int wScreen, int hScreen) {

        Random random = new Random();
        String text;
        int size, color, orient;
        for (int i = 0; i < COUNT_TEXT; i++) {
            size = random.nextInt(20) + 10;
            color = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
            orient = random.nextInt(4) + 1;
            text = (char) (random.nextInt(26) + 65) + "";
            mListText.add(new Text(text, random.nextInt(wScreen), random.nextInt(hScreen), color, size, orient));
        }
    }

    public void drawAll(Canvas canvas, Paint paint) {
        for (Text text : mListText) {
            text.draw(canvas, paint);
        }
    }

    public void moveAll(int wScreen, int hScreen) {
        for (Text text : mListText) {
           text.move(wScreen, hScreen);
        }
    }
}
