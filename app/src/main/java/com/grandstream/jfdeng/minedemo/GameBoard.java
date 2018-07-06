package com.grandstream.jfdeng.minedemo;

import android.graphics.Canvas;

import java.io.Serializable;

/**
 * Created by yf on 18-7-6.
 */

public class GameBoard implements Serializable {

    private float xNum = 10;
    private float yNum = 10;
    private float gridWidth;

    private Point startPoint;

    private Grid[][] mGrids;

    public GameBoard(){}

    public float getxNum() {
        return xNum;
    }

    public void setxNum(float xNum) {
        this.xNum = xNum;
    }

    public float getyNum() {
        return yNum;
    }

    public void setyNum(float yNum) {
        this.yNum = yNum;
    }

    public void setBroadSize(int x,int y) {
        xNum = x;
        yNum = y;
        mGrids = new Grid[x][y];
    }

    public void draw(Canvas canvas) {
        for (int i=0;i<mGrids.length;i++){
            for (int j=0;j<mGrids[i].length;j++){
                mGrids[i][j].draw(canvas);
            }
        }
    }

    public float getGridWidth() {
        return gridWidth;
    }

    public void setGridWidth(float gridWidth) {
        this.gridWidth = gridWidth;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public Grid[][] getGrids() {
        return mGrids;
    }

    public void setGrids(Grid[][] grids) {
        mGrids = grids;
    }

    public void initGridsPositionByScreenSize(float width, float height) {
        float x = 0;
        float y = (height - width) / 2;
        startPoint = new Point(x,y);
        gridWidth = width/10;
        Grid grid = null;
        for (int i=0;i<mGrids.length;i++){
            for(int j=0;j<mGrids[i].length;j++){
                grid = new Grid(new Point(x,y),new Point(x+gridWidth,y+gridWidth));
                grid.setValue(10);
                if (j/2==1){
                    grid.setShowValue(true);
                }
                mGrids[i][j] = grid;
                x+=gridWidth;
            }
            y+=gridWidth;
        }
    }
}
