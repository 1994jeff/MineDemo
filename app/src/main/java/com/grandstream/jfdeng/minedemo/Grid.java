package com.grandstream.jfdeng.minedemo;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

import java.io.Serializable;

/**
 * Created by yf on 18-7-6.
 */

public class Grid implements Serializable{

    private boolean isShowValue;
    private int value;
    private Drawable defaultDrawable;
    private Point mPointStart;
    private Point mPointEnd;

    Paint mPaint;

    public Point getPointStart() {
        return mPointStart;
    }

    public void setPointStart(Point pointStart) {
        mPointStart = pointStart;
    }

    public Point getPointEnd() {
        return mPointEnd;
    }

    public void setPointEnd(Point pointEnd) {
        mPointEnd = pointEnd;
    }

    public Grid(Point pointStart,Point pointEnd){
        this.mPointStart = pointStart;
        this.mPointEnd = pointEnd;
        mPaint = new Paint();
    }

    public boolean isShowValue() {
        return isShowValue;
    }

    public void setShowValue(boolean showValue) {
        isShowValue = showValue;
    }

    public int isValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Drawable getDefaultDrawable() {
        return defaultDrawable;
    }

    public void setDefaultDrawable(Drawable defaultDrawable) {
        this.defaultDrawable = defaultDrawable;
    }

    public void draw(Canvas canvas) {
        if(isShowValue()){
            mPaint.setColor(Color.RED);
            mPaint.setStrokeWidth(30f);
            mPaint.setTextSize(30);
            canvas.drawText(value+"",getPointStart().getX(),getPointStart().getY(),mPaint);
        }else {
            mPaint.setColor(Color.YELLOW);
            canvas.drawRect(getPointStart().getX(),getPointStart().getY(),getPointEnd().getX(),getPointEnd().getY(),mPaint);
        }
    }
}
