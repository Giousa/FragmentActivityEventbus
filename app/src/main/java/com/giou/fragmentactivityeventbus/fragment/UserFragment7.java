package com.giou.fragmentactivityeventbus.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Description:月报界面
 * Author：Giousa
 * Date：2016/4/28
 * Email：giousa@chinayoutu.com
 */
public class UserFragment7 extends MyBaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        TextView textView = new TextView(getContext());
        textView.setText("这是 月报 界面");
        textView.setTextColor(Color.RED);

        return textView;
    }
}
