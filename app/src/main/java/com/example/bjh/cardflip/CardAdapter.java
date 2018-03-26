package com.example.bjh.cardflip;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by bjh on 2018-03-26.
 */

public class CardAdapter extends BaseAdapter {
    private static final String TAG ="CardAdapter";
    private ArrayList<Integer> mCardIntegers;
    private Activity mActivity;

    public CardAdapter(Activity activity, ArrayList<Integer> arrayList) {
        super();
        mCardIntegers = arrayList;
        mActivity = activity;
        Collections.shuffle(mCardIntegers, new Random());
    }

    @Override
    public int getCount() {
        return mCardIntegers.size();
    }

    @Override
    public Object getItem(int position) {
        return mCardIntegers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MemoryCardFrameView memoryCardFrameView = new MemoryCardFrameView(mActivity,mCardIntegers.get(position));
        int width =  getCardWidth(4,mActivity);
        int height = getCardHeight(4,mActivity);
        memoryCardFrameView.setLayoutParams(new GridView.LayoutParams(width, height));

        return memoryCardFrameView;
    }




    protected int getCardWidth(int stage, Context context)
    {
        int width = (int) dipToPixels(context,81);
        switch (stage)
        {
            case 1:
                width = (int) dipToPixels(context,93);
                break;
            case 2:
                width = (int) dipToPixels(context,81);
                break;
            case 3:
                width = (int) dipToPixels(context,81);
                break;
            case 4:
                width = (int) dipToPixels(context,81);
                break;
            case 5:
                width = (int) dipToPixels(context,81);
                break;
            case 6:
                width = (int) dipToPixels(context,60);
                break;
            case 7:
                width = (int) dipToPixels(context,63);
                break;
            case 8:
                width = (int) dipToPixels(context,52);
                break;
            case 9:
                width = (int) dipToPixels(context,52);
                break;
            case 10:
                width = (int) dipToPixels(context,48);
                break;
        }
        return width;
    }

    protected int getCardHeight(int stage, Context context)
    {
        int height = (int) dipToPixels(context,104);
        switch (stage)
        {
            case 1:
                height = (int) dipToPixels(context,120);
                break;
            case 2:
                height = (int) dipToPixels(context,104);
                break;
            case 3:
                height = (int) dipToPixels(context,104);
                break;
            case 4:
                height = (int) dipToPixels(context,104);
                break;
            case 5:
                height = (int) dipToPixels(context,104);
                break;
            case 6:
                height = (int) dipToPixels(context,78);
                break;
            case 7:
                height = (int) dipToPixels(context,81);
                break;
            case 8:
                height = (int) dipToPixels(context,67);
                break;
            case 9:
                height = (int) dipToPixels(context,67);
                break;
            case 10:
                height = (int) dipToPixels(context,61);
                break;
        }
        return height;
    }

    public static int dipToPixels(Context context, float dipValue) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dipValue, metrics);
    }
}
