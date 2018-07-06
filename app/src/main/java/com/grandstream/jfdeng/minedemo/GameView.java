package com.grandstream.jfdeng.minedemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by yf on 18-7-6.
 */

public class GameView extends View {

    float screenWidth;
    float screenHeight;

    GameBoard mBoard;

    public GameView(Context context) {
        super(context);
        init(null);
    }

    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public GameView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public void init(AttributeSet attr){

    }

    public void initGame(){
        initScreen();
    }

    private void initScreen() {
        getScreenSize();
        initGameParams();
    }

    private void initGameParams() {
        mBoard = new GameBoard();
        mBoard.setBroadSize(10,10);
        mBoard.initGridsPositionByScreenSize(screenWidth,screenHeight);
    }

    private void getScreenSize() {
        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(metrics);
        screenWidth = metrics.widthPixels;
        screenHeight = metrics.heightPixels;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.BLACK);
        mBoard.draw(canvas);
    }
}
