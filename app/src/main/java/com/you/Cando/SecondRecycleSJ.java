package com.you.Cando;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

public class SecondRecycleSJ extends Fragment {
    private ListView rListView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        LinearLayout layout = (LinearLayout)inflater.inflate(R.layout.first_recycle, container, false);

        rListView =(ListView)layout.findViewById(R.id.recycleList);

        dataSetting();
        return layout;

    }

    private void dataSetting(){

        MyAdapter rMyAdapter = new MyAdapter();
        String place = "수정관 2F";

        /* 리스트뷰에 어댑터 등록 */
        rListView.setAdapter(rMyAdapter);


    }

}