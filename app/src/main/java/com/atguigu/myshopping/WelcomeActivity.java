package com.atguigu.myshopping;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MotionEvent;


public class WelcomeActivity extends AppCompatActivity {


    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);


        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startMainActivity();
            }
        }, 2000);
    }

    /**
     * 启动主页面
     */
    private void startMainActivity() {
        Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //关闭所有handler
        handler.removeCallbacksAndMessages(null);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            if (event.getAction() == KeyEvent.ACTION_DOWN) {
                //关闭所有handler
                handler.removeCallbacksAndMessages(null);
                startMainActivity();
                return true;
            }
        }
        return super.onTouchEvent(event);
    }
}
