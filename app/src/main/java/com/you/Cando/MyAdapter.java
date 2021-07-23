package com.you.Cando;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dinuscxj.progressbar.CircleProgressBar;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter implements CircleProgressBar.ProgressFormatter{
    /* 아이템을 세트로 담기 위한 어레이 */
    private ArrayList<MyItem> mItems = new ArrayList<>();

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public MyItem getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        CircleProgressBar circleBar;
        Context context = parent.getContext();

        /* 'listview_custom' Layout을 inflate하여 convertView 참조 획득 */
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_custom, parent, false);
        }

        /* 'listview_custom'에 정의된 위젯에 대한 참조 획득 */
        ImageView iv_img = (ImageView) convertView.findViewById(R.id.iv_img) ;
        TextView tv_name = (TextView) convertView.findViewById(R.id.tv_name) ;
        TextView tv_contents = (TextView) convertView.findViewById(R.id.tv_contents) ;
        circleBar = (CircleProgressBar)convertView.findViewById(R.id.circlebar);


        /* 각 리스트에 뿌려줄 아이템을 받아오는데 mMyItem 재활용 */
        MyItem myItem = getItem(position);

        /* 각 위젯에 세팅된 아이템을 뿌려준다 */
        iv_img.setImageDrawable(myItem.getIcon());
        tv_name.setText(myItem.getName());
        tv_contents.setText(myItem.getContents());
        circleBar.setProgress(myItem.getProgress());
        String place = myItem.getPlace().toString();

        //값 받아오기

        /* (위젯에 대한 이벤트리스너를 지정하고 싶다면 여기에 작성하면된다..)  */
        iv_img.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(context, R.style.MyDialogTheme);
                View dlgView = View.inflate(context, R.layout.dialog, null);

                ImageView imageView;
                imageView = (ImageView) dlgView.findViewById(R.id.imageView);


                TextView txt = (TextView)dlgView.findViewById(R.id.place);
                txt.setText(myItem.getContents() + " " + myItem.getName() + "쓰레기통입니다.");


                //수정관 1층
                int sj_m_first[] = {R.drawable.sj_m_1,R.drawable.sj_m_2,R.drawable.sj_m_3 };
                int sj_r_first[] = {R.drawable.sj_r_1 };

                //수정관2층
                int sj_m_second[] = {R.drawable.sj_m_21,R.drawable.sj_m_22 };

                //수정관3
                int sj_m_third[] = {R.drawable.sj_m_31,R.drawable.sj_m_32, R.drawable.sj_m_33 };
                int sj_r_third[] = {R.drawable.sj_r_31 };

                switch (place)
                {
                    case "수정관 1F":
                        switch (myItem.getName()) {
                            case "일반":
                                switch (pos) {
                                    case 0:

                                        imageView.setImageResource(sj_m_first[pos]);
                                        dlg.setView(dlgView);
                                        dlg.setPositiveButton("확인",
                                                new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog, int which) {
                                                        Toast.makeText(context.getApplicationContext(), "쓰레기통 위치를 확인했습니다.", Toast.LENGTH_LONG).show();
                                                    }
                                                });
                                        dlg.show();
                                        break;

                                    case 1:
                                        imageView.setImageResource(sj_m_first[pos]);

                                        dlg.setView(dlgView);
                                        dlg.setPositiveButton("확인",
                                                new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog, int which) {
                                                        Toast.makeText(context.getApplicationContext(), "쓰레기통 위치를 확인했습니다.", Toast.LENGTH_LONG).show();
                                                    }
                                                });
                                        dlg.show();
                                        break;

                                    case 2:
                                        imageView.setImageResource(sj_m_first[pos]);

                                        dlg.setView(dlgView);
                                        dlg.setPositiveButton("확인",
                                                new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog, int which) {
                                                        Toast.makeText(context.getApplicationContext(), "쓰레기통 위치를 확인했습니다.", Toast.LENGTH_LONG).show();
                                                    }
                                                });
                                        dlg.show();
                                        break;

                                }
                                break;

                            case "재활용":
                                switch (pos)
                                {
                                    case 0:

                                        imageView.setImageResource(sj_r_first[pos]);
                                        dlg.setView(dlgView);
                                        dlg.setPositiveButton("확인",
                                                new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog, int which) {
                                                        Toast.makeText(context.getApplicationContext(), "쓰레기통 위치를 확인했습니다.", Toast.LENGTH_LONG).show();
                                                    }
                                                });
                                        dlg.show();
                                        break;
                                }
                                break;
                        }
                        break;

                    case "수정관 2F":
                        switch (myItem.getName()) {
                            case "일반":
                                switch (pos) {
                                    case 0:

                                        imageView.setImageResource(sj_m_second[pos]);
                                        dlg.setView(dlgView);
                                        dlg.setPositiveButton("확인",
                                                new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog, int which) {
                                                        Toast.makeText(context.getApplicationContext(), "쓰레기통 위치를 확인했습니다.", Toast.LENGTH_LONG).show();
                                                    }
                                                });
                                        dlg.show();
                                        break;

                                    case 1:
                                        imageView.setImageResource(sj_m_second[pos]);

                                        dlg.setView(dlgView);
                                        dlg.setPositiveButton("확인",
                                                new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog, int which) {
                                                        Toast.makeText(context.getApplicationContext(), "쓰레기통 위치를 확인했습니다.", Toast.LENGTH_LONG).show();
                                                    }
                                                });
                                        dlg.show();
                                        break;
                                }
                                break;
                        }
                        break;

                    case"수정관 3F":
                        switch (myItem.getName()) {
                            case "일반":
                                switch (pos) {
                                    case 0:

                                        imageView.setImageResource(sj_m_third[pos]);
                                        dlg.setView(dlgView);
                                        dlg.setPositiveButton("확인",
                                                new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog, int which) {
                                                        Toast.makeText(context.getApplicationContext(), "쓰레기통 위치를 확인했습니다.", Toast.LENGTH_LONG).show();
                                                    }
                                                });
                                        dlg.show();
                                        break;

                                    case 1:
                                        imageView.setImageResource(sj_m_third[pos]);

                                        dlg.setView(dlgView);
                                        dlg.setPositiveButton("확인",
                                                new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog, int which) {
                                                        Toast.makeText(context.getApplicationContext(), "쓰레기통 위치를 확인했습니다.", Toast.LENGTH_LONG).show();
                                                    }
                                                });
                                        dlg.show();
                                        break;

                                    case 2:
                                        imageView.setImageResource(sj_m_third[pos]);

                                        dlg.setView(dlgView);
                                        dlg.setPositiveButton("확인",
                                                new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog, int which) {
                                                        Toast.makeText(context.getApplicationContext(), "쓰레기통 위치를 확인했습니다.", Toast.LENGTH_LONG).show();
                                                    }
                                                });
                                        dlg.show();
                                        break;


                                }
                                break;

                            case "재활용":
                                switch (pos)
                                {
                                    case 0:

                                        imageView.setImageResource(sj_r_third[pos]);
                                        dlg.setView(dlgView);
                                        dlg.setPositiveButton("확인",
                                                new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog, int which) {
                                                        Toast.makeText(context.getApplicationContext(), "쓰레기통 위치를 확인했습니다.", Toast.LENGTH_LONG).show();
                                                    }
                                                });
                                        dlg.show();
                                        break;
                                }
                                break;
                        }


                        break;

                    case "성신관 1F":
                        break;
                }
            }
        });
        return convertView;
    }
    /* 아이템 데이터 추가를 위한 함수. 자신이 원하는대로 작성 */
    public void addItem(Drawable img, String name, String contents,int progress, String place) {

        MyItem mItem = new MyItem();

        /* MyItem에 아이템을 setting한다. */
        mItem.setIcon(img);
        mItem.setName(name);
        mItem.setContents(contents);
        mItem.setProgress(progress);
        mItem.setPlace(place);
        /* mItems에 MyItem을 추가한다. */
        mItems.add(mItem);

    }

    @Override
    public CharSequence format(int progress, int max) {
        return String.format("%d%%",
                (int) ((float)progress / (float)max * 100));

    }
}