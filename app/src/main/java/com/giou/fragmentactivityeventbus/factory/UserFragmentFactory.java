package com.giou.fragmentactivityeventbus.factory;

import com.giou.fragmentactivityeventbus.fragment.MyBaseFragment;
import com.giou.fragmentactivityeventbus.fragment.UserFragment1;
import com.giou.fragmentactivityeventbus.fragment.UserFragment2;
import com.giou.fragmentactivityeventbus.fragment.UserFragment3;
import com.giou.fragmentactivityeventbus.fragment.UserFragment4;
import com.giou.fragmentactivityeventbus.fragment.UserFragment5;
import com.giou.fragmentactivityeventbus.fragment.UserFragment6;
import com.giou.fragmentactivityeventbus.fragment.UserFragment7;
import com.giou.fragmentactivityeventbus.fragment.UserFragment8;

import java.util.HashMap;

/**
 * Description:
 * Author：Giousa
 * Date：2016/4/29
 * Email：giousa@chinayoutu.com
 */
public class UserFragmentFactory {

    private static HashMap<Integer, MyBaseFragment> hashMap = new HashMap<Integer, MyBaseFragment>();
    public static MyBaseFragment createFragment(int arg0) {
        //内存中如果已经有当前根据索引生成的fragment,复用之前的fragment对象,内存中没有索引指向的fragment对象,创建
        MyBaseFragment fragment = hashMap.get(arg0);
        if(fragment!=null){
            return fragment;
        }else{
            switch (arg0) {
                case 0:
                    fragment = new UserFragment1();
                    break;
                case 1:
                    fragment = new UserFragment2();
                    break;
                case 2:
                    fragment = new UserFragment3();
                    break;
                case 3:
                    fragment = new UserFragment4();
                    break;
                case 4:
                    fragment = new UserFragment5();
                    break;
                case 5:
                    fragment = new UserFragment6();
                    break;
                case 6:
                    fragment = new UserFragment7();
                    break;
                case 7:
                    fragment = new UserFragment8();
                    break;
            }
            //集合将创建过的fragment,管理起来
            hashMap.put(arg0, fragment);
            return fragment;
        }
    }

}
