package com.giou.fragmentactivityeventbus;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.giou.fragmentactivityeventbus.factory.UserFragmentFactory;
import com.giou.fragmentactivityeventbus.model.FirstEvent;
import com.giou.fragmentactivityeventbus.model.SecondEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    @InjectView(R.id.rb_userinfo1)
    RadioButton mRbUserinfo1;
    @InjectView(R.id.rg_user_radiogroup1)
    RadioGroup mRgUserRadiogroup1;
    @InjectView(R.id.rg_user_radiogroup2)
    RadioGroup mRgUserRadiogroup2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        //注册
        EventBus.getDefault().register(this);
        ButterKnife.inject(this);
        initView();
    }


    private void initView() {
        mRgUserRadiogroup1.setOnCheckedChangeListener(this);
        mRgUserRadiogroup2.setOnCheckedChangeListener(this);
        mRbUserinfo1.setChecked(true);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.rb_userinfo1:

                changeFragment(UserFragmentFactory.createFragment(0));
                break;
            case R.id.rb_userinfo2:

                changeFragment(UserFragmentFactory.createFragment(1));
                break;
            case R.id.rb_userinfo3:
                changeFragment(UserFragmentFactory.createFragment(2));
                break;
            case R.id.rb_userinfo4:
                changeFragment(UserFragmentFactory.createFragment(3));
                break;
            case R.id.rb_userinfo5:
                changeFragment(UserFragmentFactory.createFragment(4));
                break;
            case R.id.rb_userinfo6:
                changeFragment(UserFragmentFactory.createFragment(5));
                break;
            case R.id.rb_userinfo7:
                changeFragment(UserFragmentFactory.createFragment(6));
                break;
            case R.id.rb_userinfo8:
                changeFragment(UserFragmentFactory.createFragment(7));
                break;
        }
    }

    private void changeFragment(Fragment targetFragment) {

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_info_framlayout, targetFragment, "fragment")
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

    @Subscribe
    public void onEventMainThread(SecondEvent event) {

        String msg = "收到消息：" + event.getMsg();
        Log.d("MainActivity", msg);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //注销
        EventBus.getDefault().unregister(this);//反注册EventBus
    }

    @OnClick(R.id.btn_send)
    public void onClick() {
        Log.d("MainActivity", "被执行了");
        //发送消息
        EventBus.getDefault().post(
                new FirstEvent("MainActivity 发送的数据 FirstEvent btn clicked"));
    }
}
