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

public class SecondTrashSJ extends Fragment  {

    private ListView mListView;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LinearLayout layout = (LinearLayout)inflater.inflate(R.layout.first_trash, container, false);

        mListView =(ListView)layout.findViewById(R.id.trashList);

        dataSetting();
        return layout;

    }
    private void dataSetting(){

        MyAdapter mMyAdapter = new MyAdapter();
        String place = "수정관 2F";


        mMyAdapter.addItem(ContextCompat.getDrawable(getContext(), R.drawable.marker), "일반" /*+ i*/, "중앙) 교육지원 소프트웨어관리실 앞 화장실",20, place);
        mMyAdapter.addItem(ContextCompat.getDrawable(getContext(), R.drawable.marker), "일반" /*+ i*/, "왼쪽) 206강의실 앞 화장실",30, place);
        /* 리스트뷰에 어댑터 등록 */
        mListView.setAdapter(mMyAdapter);
    }

}
