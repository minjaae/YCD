package com.you.Cando;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.dinuscxj.progressbar.CircleProgressBar;

public class FirstTrashSJ extends Fragment  {

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
        String place = "수정관 1F";

        mMyAdapter.addItem(ContextCompat.getDrawable(getContext(), R.drawable.marker), "일반" /*+ i*/, "왼쪽 화장실 앞",20, place);
        mMyAdapter.addItem(ContextCompat.getDrawable(getContext(), R.drawable.marker), "일반" /*+ i*/, "중앙 계단 오른쪽",30, place);
        mMyAdapter.addItem(ContextCompat.getDrawable(getContext(), R.drawable.marker), "일반" /*+ i*/, "오른쪽 엘레베이터 자판기 옆",80, place);
        /* 리스트뷰에 어댑터 등록 */
        mListView.setAdapter(mMyAdapter);
    }

}
