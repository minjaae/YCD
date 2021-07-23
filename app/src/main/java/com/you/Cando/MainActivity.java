package com.you.Cando;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Handler handler = new Handler() {

            public void handleMessage(Message msg) {

                super.handleMessage(msg);

                startActivity(new Intent(MainActivity.this, Second.class));

                finish();

            }

        };

        handler.sendEmptyMessageDelayed(0, 2000); //3초후 화면전환

    }
}