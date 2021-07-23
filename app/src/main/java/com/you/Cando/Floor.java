package com.you.Cando;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class Floor extends AppCompatActivity {
    TextView txt;
    Button trash, recycle;
    private FirstTrashSJ firstTrashSJ;
    private FirstRecycleSJ firstRecycleSJ;
    private SecondRecycleSJ secondRecycleSJ;
    private SecondTrashSJ secondTrashSJ;
    private ThirdRecycleSJ thirdRecycleSJ;
    private ThirdTrashSJ thirdTrashSJ;

    private ListView mListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.floor);


        txt=(TextView)findViewById(R.id.txt);
        trash=(Button)findViewById(R.id.trash);
        recycle=(Button)findViewById(R.id.recycle);



        Intent intent = getIntent();//받는다
        String str = intent.getStringExtra("str");//String 데이타 받기
        String name = intent.getStringExtra("name");
        str = name + " " + str;
        txt.setText(str);//받아 온 데이터 tv_second 에 넣기

        //fragment
        firstTrashSJ = new FirstTrashSJ();
        firstRecycleSJ = new FirstRecycleSJ();

        secondTrashSJ = new SecondTrashSJ();
        secondRecycleSJ = new SecondRecycleSJ();

        thirdRecycleSJ = new ThirdRecycleSJ();
        thirdTrashSJ = new ThirdTrashSJ();

        //관마다, 층마다 다른 프레임 출력
        switch (str)
        {
            case "수정관 1F":
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,firstTrashSJ).commit();
                trash.setTextColor(Color.BLACK);
                recycle.setTextColor(Color.parseColor("#1fffffff"));

                trash.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,firstTrashSJ).commit();
                        trash.setTextColor(Color.BLACK);
                        recycle.setTextColor(Color.parseColor("#1fffffff"));
                    }
                });

                recycle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,firstRecycleSJ).commit();
                        recycle.setTextColor(Color.BLACK);
                        trash.setTextColor(Color.parseColor("#1fffffff"));
                    }
                });

                break;



            case "수정관 2F":

                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,secondTrashSJ).commit();
                trash.setTextColor(Color.BLACK);
                recycle.setTextColor(Color.parseColor("#1fffffff"));

                trash.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,secondTrashSJ).commit();
                        trash.setTextColor(Color.BLACK);
                        recycle.setTextColor(Color.parseColor("#1fffffff"));
                    }
                });

                recycle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        
                        //2층은 재활용 없음
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, secondRecycleSJ).commit();
                        recycle.setTextColor(Color.BLACK);
                        trash.setTextColor(Color.parseColor("#1fffffff"));
                    }
                });
                break;


            case "수정관 3F":

                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,thirdTrashSJ).commit();
                trash.setTextColor(Color.BLACK);
                recycle.setTextColor(Color.parseColor("#1fffffff"));

                trash.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,thirdTrashSJ).commit();
                        trash.setTextColor(Color.BLACK);
                        recycle.setTextColor(Color.parseColor("#1fffffff"));
                    }
                });

                recycle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        //2층은 재활용 없음
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, thirdRecycleSJ).commit();
                        recycle.setTextColor(Color.BLACK);
                        trash.setTextColor(Color.parseColor("#1fffffff"));
                    }
                });
                break;
        }
    }



}