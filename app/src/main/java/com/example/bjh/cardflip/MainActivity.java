package com.example.bjh.cardflip;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView mGridView;
    MemoryCardFrameView mPreCardFrameView;

    boolean mClickEnable = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mGridView = (GridView)findViewById(R.id.gridView);

        mGridView.setNumColumns(3); // 3by임의 가로 열의 개수를 지정할수 있다.

        ArrayList<Integer> arrayList = new ArrayList<>(); // 임의로 넣어줬다. 나중에는 랜덤으로
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(3);

        mGridView.setAdapter(new CardAdapter(this,arrayList));
        mGridView.setOnItemClickListener(mOnItemClickListener);
    }


    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            // 카드 클릭시 호출 된다.
            if(mClickEnable == false)
                return;

            final MemoryCardFrameView memoryCardFrameView = (MemoryCardFrameView)view;
            if(mPreCardFrameView == null) // 한장을 처음 열때
            {
                mPreCardFrameView = memoryCardFrameView;
                memoryCardFrameView.onFlip();
            }
            else // 두장째 열때
            {
                if(mPreCardFrameView.getCardNum() == memoryCardFrameView.getCardNum())
                {
                    // 정답일 경우
                    memoryCardFrameView.onFlip();
                    memoryCardFrameView.mComplete = true;
                    mPreCardFrameView.mComplete = true;
                    mPreCardFrameView = null; // 다시 한장부터 시작
                }
                else
                {
                    // 정답이 아닐경우
                    mClickEnable = false;
                    memoryCardFrameView.onFlip();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            memoryCardFrameView.onFlip();
                            mPreCardFrameView.onFlip();
                            mPreCardFrameView = null;
                            mClickEnable = true;
                        }
                    },400);
                }
            }
        }
    };
}
