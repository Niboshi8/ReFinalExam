package com.example.niboshi8.gameapp;

import android.graphics.Canvas;
import android.renderscript.BaseObj;

public abstract class MovingMethod { // abstract: 継承、実装されて初めてインスタンス化される

    // 当たり判定の処理をする
    static final int NORMAL = -1;  // 画面内
    static final int ABNORMAL = 0; // 画面外 (死状態)

    int status = NORMAL;

    // MovingMethod を継承するクラスを格納 (列挙型)
    enum Type{
        MyArea,
        MyBullet
    }

    // 描画位置の中心座標
    float xPosition; // x 座標
    float yPosition; // y 座標

    // 体力
    int hp;

    //// 各メソッド 詳細は各クラス内で記述
    // 描画メソッド
    public abstract void draw(Canvas canvas);
    // 移動メソッド
    public abstract void move();
    // MovingMethod を継承するクラスを取得
    public abstract Type getType();
    // 衝突判定メソッド
    public abstract boolean isHit(MovingMethod object);

    //// 各メソッド
    // 画面外での判定処理
    public boolean isAvailable(int width, int height){
        if (xPosition<0||yPosition<0||xPosition>width||yPosition>height)
            return false;
        if (status == ABNORMAL)
            return false;
        return false;
    }
    // 死状態に変更するメソッド
    public void hit(){
        status = ABNORMAL;
    }

    // オブジェクト間の距離を計算
    static double Dist(MovingMethod object1, MovingMethod object2){
        float distX = object1.xPosition - object2.xPosition;
        float distY = object1.yPosition - object2.yPosition;
        return Math.sqrt(Math.pow(distX, 2) + Math.pow(distY, 2));
    }

}
