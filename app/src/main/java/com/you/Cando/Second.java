package com.you.Cando;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class Second extends AppCompatActivity {

    TextView showSJ, showSS;
    ListView listSJ, listSS;
    String name;
    ImageView ssHere, sjHere, school;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ssHere = (ImageView)findViewById(R.id.ssHere);
        sjHere = (ImageView)findViewById(R.id.sjHere);
        school = (ImageView)findViewById(R.id.school);

        ssHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                school.setImageResource(R.drawable.school_ss);
            }
        });

        sjHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                school.setImageResource(R.drawable.school_sj);
            }
        });


        showSJ = (TextView)findViewById(R.id.showSJ);
        showSS = (TextView)findViewById(R.id.showSS);
        listSJ = (ListView)findViewById(R.id.listSJ);
        listSS = (ListView)findViewById(R.id.listSS);

        final String[] FloorSJ = {"1F", "2F", "3F", "4F", "5F", "6F", "7F"};
        final String[] FloorSS = {"1F", "2F", "3F", "4F", "5F", "6F", "7F"};


        ArrayAdapter<String> adapterSJ = new ArrayAdapter<String>(this, R.layout.list_main, FloorSJ);
        listSJ.setAdapter(adapterSJ);

        ArrayAdapter<String> adapterSS = new ArrayAdapter<String>(this, R.layout.list_main, FloorSS);
        listSS.setAdapter(adapterSS);

        listSJ.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String str;
                Intent intent;

                str = FloorSJ[i];
                name = showSJ.getText().toString();

                intent = new Intent(Second.this, Floor.class);
                intent.putExtra("str", str);//str에있는 값을 가져 가겠다
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });

        listSS.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String str;
                Intent intent;

                str = FloorSS[i];
                name = showSS.getText().toString();

                intent = new Intent(Second.this, Floor.class);
                intent.putExtra("str", str);//str에있는 값을 가져 가겠다
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });




        showSJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listSJ.getVisibility() == View.GONE)
                    listSJ.setVisibility(View.VISIBLE);
                else if(listSJ.getVisibility() == View.VISIBLE)
                    listSJ.setVisibility(View.GONE);
            }
        });

        showSS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listSS.getVisibility() == View.GONE)
                    listSS.setVisibility(View.VISIBLE);
                else if(listSS.getVisibility() == View.VISIBLE)
                    listSS.setVisibility(View.GONE);
            }
        });


        listViewHeightSet(adapterSJ, listSJ);
        listViewHeightSet(adapterSS, listSS);

    }


    //리스트뷰 짤려서 이거 있어야 리스트뷰가 다 보임
    private void listViewHeightSet(Adapter listAdapter, ListView listView){
        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }
}