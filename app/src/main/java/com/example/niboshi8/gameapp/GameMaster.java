package com.example.niboshi8.gameapp;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class GameMaster extends SurfaceView implements SurfaceHolder.Callback {

    // コールバック用のインターフェースを定義
    public interface Callback{}

    // コールバックするオブジェクトにアクセスするときに使用
    private Callback callback;

    // 呼び出すコールバックメソッドを指定
    public void setCallback(Callback callback){ this.callback = callback; }

    // 例外処理するときに使用
    private Handler handler;

    // コンストラクタ
    public GameMaster(Context context){ // Surface が描画できる状態のときにコールバックを呼ぶ
        super(context);
        // ホルダーのコールバックに自身を設定
        getHolder().addCallback(this);
    }

    // SurfaceHolder.callback に必要なメソッド
    @Override // Surface が作られたときに呼ばれる
    public void surfaceCreated(SurfaceHolder holder){}
    @Override // Surface が変化したときに呼ばれる
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height){}
    @Override // Surface が壊されたときに呼ばれる
    public void surfaceDestroyed(SurfaceHolder holder){}
}
