package com.jeo.reactupdate;

import android.content.Intent;
import android.os.Bundle;

import com.facebook.react.ReactActivity;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;
import com.reactnative.horsepush.HorsePush;
import com.reactnative.horsepush.HorsePushStartPage;

import java.util.Arrays;
import java.util.List;


public class MainActivity extends ReactActivity {

    /**
     * Returns the name of the main component registered from JavaScript.
     * This is used to schedule rendering of the component.
     */
    @Override
    protected String getMainComponentName() {
        return "AwesomeProject2";
    }

    /**
     * Returns whether dev mode should be enabled.
     * This enables e.g. the dev menu.
     */
    @Override
    protected boolean getUseDeveloperSupport() {
        return true;
    }

    /**
     * A list of packages used by the app. If the app uses additional views
     * or modules besides the default ones, add more packages here.
     */
    @Override
    protected List<ReactPackage> getPackages() {
        return Arrays.<ReactPackage>asList(
                new MainReactPackage()
        );
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivity(new Intent().setClass(getApplicationContext(), HorsePushStartPage.class));// <------ 加入这个代码，使用启动屏
    }

    @Override
    protected String getJSBundleFile() {
        return HorsePush.getJSBundleFile(this); // <------ 加入这个代码告诉rn通过本地启动
    }
    @Override
    protected void onResume() {
        super.onResume();
        HorsePush.reCheckUpdate();//<------每次从后台返回都会尝试更新
    }
}
