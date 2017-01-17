package com.giou.fragmentactivityeventbus.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.giou.fragmentactivityeventbus.model.FirstEvent;
import com.giou.fragmentactivityeventbus.model.SecondEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * Description:我的界面
 * Author：Giousa
 * Date：2016/4/28
 * Email：giousa@chinayoutu.com
 */
public class UserFragment1 extends MyBaseFragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //注册
        EventBus.getDefault().register(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        TextView textView = new TextView(getContext());
        textView.setText("这是 我的 界面");
        textView.setTextColor(Color.RED);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().post(
                        new SecondEvent("UserFragment1 发送的数据 SecondEvent btn clicked"));
            }
        });

        return textView;
    }

    //备注:只有当显示这个界面的时候,才能收到消息
    //接收消息 @Subscribe注意,这个千万不要忘记
    @Subscribe
    public void onEventMainThread(FirstEvent event) {

        String msg = "onEventMainThread收到了消息：" + event.getMsg();
        Log.d("UserFragment1", msg);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //注销
        EventBus.getDefault().unregister(this);
    }
}
