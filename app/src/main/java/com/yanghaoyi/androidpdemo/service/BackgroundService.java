package com.yanghaoyi.androidpdemo.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * @author : YangHaoYi on 2018/8/2.
 *         Email  :  yang.haoyi@qq.com
 *         Description :
 *         Change : YangHaoYi on 2018/8/2.
 *         Version : V 1.0
 */
public class BackgroundService extends Service{

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this,"后台拉起服务",Toast.LENGTH_LONG).show();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
