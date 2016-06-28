package com.jeo.reactupdate;

import android.app.Application;

import com.reactnative.horsepush.HorsePush;

/**
 * Created by Administrator on 2016/6/28.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        HorsePush.getInstance(getApplicationContext(), "http://192.168.211.166:8889", "test");// <------ 加入这个代码
    }
}
