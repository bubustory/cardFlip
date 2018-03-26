package com.example.bjh.cardflip;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;

/**
 * Created by bjh on 2018-03-26.
 */

public class MemoryCardFrameView extends FrameLayout {

    private int mCardNum;

    public boolean mComplete = false; // 사용자가 카드를 맞추면 true 로 변경시켜 준다.


    // 앞면 뒷면 이미지
    private ImageView mCardFrantView;
    private ImageView mCardBackView;

    // 뒤집는 애니메이션
    protected AnimatorSet mSetRightOutAni;
    protected AnimatorSet mSetLeftInAni;

    public MemoryCardFrameView(@NonNull Context context , int cardNum) {
        super(context);
        init(cardNum);
    }

    private void init(int cardNum)
    {
        mCardNum = cardNum;
        mCardBackView = new ImageView(getContext());
        mCardBackView.setBackgroundResource(R.drawable.ic_lock);
        addView(mCardBackView);
        setFrontImage(cardNum);

        mCardBackView.setAlpha(1.0f);
        mCardFrantView.setAlpha(0.0f);

        // 애니메이션
        mSetRightOutAni = (AnimatorSet) AnimatorInflater.loadAnimator(getContext(), R.animator.flight_right_out);
        mSetLeftInAni = (AnimatorSet) AnimatorInflater.loadAnimator(getContext(), R.animator.flight_left_in);
    }

    public int getCardNum(){
        return mCardNum;
    }


    public void onFlip()// 사용자의 의해 뒤집힌다.
    {
        if(mComplete)
            return;

        if(mCardBackView.getAlpha() == 0.0f)
        {
            mSetRightOutAni.setTarget(mCardFrantView);
            mSetLeftInAni.setTarget(mCardBackView);
            mSetRightOutAni.start();
            mSetLeftInAni.start();
        }
        else
        {
            mSetRightOutAni.setTarget(mCardBackView);
            mSetLeftInAni.setTarget(mCardFrantView);
            mSetRightOutAni.start();
            mSetLeftInAni.start();
        }
    }


    private void setFrontImage(int cardNum)
    {
        if(mCardFrantView == null)
            mCardFrantView = new ImageView(getContext());

        switch (cardNum)
        {
            case 1:
                mCardFrantView.setBackgroundResource(R.drawable.game_card_001);
                break;
            case 2:
                mCardFrantView.setBackgroundResource(R.drawable.game_card_002);
                break;
            case 3:
                mCardFrantView.setBackgroundResource(R.drawable.game_card_003);
                break;
            case 4:
                mCardFrantView.setBackgroundResource(R.drawable.game_card_004);
                break;
            case 5:
                mCardFrantView.setBackgroundResource(R.drawable.game_card_005);
                break;
            case 6:
                mCardFrantView.setBackgroundResource(R.drawable.game_card_006);
                break;
            case 7:
                mCardFrantView.setBackgroundResource(R.drawable.game_card_007);
                break;
            case 8:
                mCardFrantView.setBackgroundResource(R.drawable.game_card_008);
                break;
            case 9:
                mCardFrantView.setBackgroundResource(R.drawable.game_card_009);
                break;
            case 10:
                mCardFrantView.setBackgroundResource(R.drawable.game_card_010);
                break;
        }
        addView(mCardFrantView);
    }
}
