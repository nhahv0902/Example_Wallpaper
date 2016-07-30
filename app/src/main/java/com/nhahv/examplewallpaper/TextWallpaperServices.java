package com.nhahv.examplewallpaper;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.service.wallpaper.WallpaperService;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.WindowInsets;

import java.io.FileDescriptor;
import java.io.PrintWriter;

/**
 * Created by Nhahv on 7/30/2016.
 * <></>
 */

public class TextWallpaperServices extends WallpaperService {

    @Override
    public Engine onCreateEngine() {
        return new TextEngine();
    }

    private class TextEngine extends Engine {

        private boolean isVisibility;
        private Handler handler = new Handler();
        private Runnable runnable = new Runnable() {
            @Override
            public void run() {
                drawText();
                if (isVisibility) {
                    handler.postDelayed(this, 100);
                }
            }
        };

        private SurfaceHolder holder;
        private Paint paint = new Paint();

        private TextManager textManager;
        private int wScreen, hScreen;

        @Override
        public void onCreate(SurfaceHolder surfaceHolder) {
            super.onCreate(surfaceHolder);

            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(5);

            textManager = new TextManager();

            wScreen = getResources().getDisplayMetrics().widthPixels;
            hScreen = getResources().getDisplayMetrics().heightPixels;
            textManager.initListText(wScreen, hScreen);

        }

        // surfaceHolder la doi tuong ve doi tuong truc tiep tren thanh ghi
        // khong qua doi tuong nao ca
        // khong dung thread de chay chi lien quan den card do hoa của máy
        @Override
        public void onSurfaceCreated(SurfaceHolder holder) {
            super.onSurfaceCreated(holder);
            this.holder = holder;
            isVisibility = true;
            handler.postDelayed(runnable, 100);
        }


        // chay nhieu lan khi set thi true
        // khi an nut nguoi thi false
        // toi uu bo nho
        @Override
        public void onVisibilityChanged(boolean visible) {
            super.onVisibilityChanged(visible);
            isVisibility = visible;
            if (isVisibility) {
                handler.postDelayed(runnable, 100);
            } else {
                handler.removeCallbacks(runnable);
            }
        }

        private void drawText() {
            if (holder == null) {
                return;
            }
            Canvas canvas = holder.lockCanvas();
            textManager.drawAll(canvas, paint);
            textManager.moveAll(wScreen, hScreen);
            holder.unlockCanvasAndPost(canvas);
        }

        public TextEngine() {
            super();
        }

        @Override
        public SurfaceHolder getSurfaceHolder() {
            return super.getSurfaceHolder();
        }

        @Override
        public int getDesiredMinimumWidth() {
            return super.getDesiredMinimumWidth();
        }

        @Override
        public int getDesiredMinimumHeight() {
            return super.getDesiredMinimumHeight();
        }

        @Override
        public boolean isVisible() {
            return super.isVisible();
        }

        @Override
        public boolean isPreview() {
            return super.isPreview();
        }

        @Override
        public void setTouchEventsEnabled(boolean enabled) {
            super.setTouchEventsEnabled(enabled);
        }

        @Override
        public void setOffsetNotificationsEnabled(boolean enabled) {
            super.setOffsetNotificationsEnabled(enabled);
        }

        @Override
        public void onDestroy() {
            super.onDestroy();
        }

        @Override
        public void onApplyWindowInsets(WindowInsets insets) {
            super.onApplyWindowInsets(insets);
        }

        @Override
        public void onTouchEvent(MotionEvent event) {
            super.onTouchEvent(event);
        }

        @Override
        public void onOffsetsChanged(float xOffset, float yOffset, float xOffsetStep, float yOffsetStep, int xPixelOffset, int yPixelOffset) {
            super.onOffsetsChanged(xOffset, yOffset, xOffsetStep, yOffsetStep, xPixelOffset, yPixelOffset);
        }

        @Override
        public Bundle onCommand(String action, int x, int y, int z, Bundle extras, boolean resultRequested) {
            return super.onCommand(action, x, y, z, extras, resultRequested);
        }

        @Override
        public void onDesiredSizeChanged(int desiredWidth, int desiredHeight) {
            super.onDesiredSizeChanged(desiredWidth, desiredHeight);
        }

        @Override
        public void onSurfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            super.onSurfaceChanged(holder, format, width, height);
        }

        @Override
        public void onSurfaceRedrawNeeded(SurfaceHolder holder) {
            super.onSurfaceRedrawNeeded(holder);
        }

        @Override
        public void onSurfaceDestroyed(SurfaceHolder holder) {
            super.onSurfaceDestroyed(holder);
        }

        @Override
        protected void dump(String prefix, FileDescriptor fd, PrintWriter out, String[] args) {
            super.dump(prefix, fd, out, args);
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        @Override
        public String toString() {
            return super.toString();
        }

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
        }
    }


}
