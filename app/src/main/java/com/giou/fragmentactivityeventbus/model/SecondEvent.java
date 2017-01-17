package com.giou.fragmentactivityeventbus.model;

/**
 * Description:
 * Author:zhangmengmeng
 * Date:2017/1/17
 * Time:下午9:11
 */

public class SecondEvent {

    private String mMsg;
    public SecondEvent(String msg) {

        mMsg = msg;
    }
    public String getMsg(){
        return mMsg;
    }
}
