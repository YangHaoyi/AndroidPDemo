package com.yanghaoyi.androidpdemo.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.yanghaoyi.androidpdemo.activity.HomeActivity;

/**
 * @author : YangHaoYi on 2018/8/2.
 *         Email  :  yang.haoyi@qq.com
 *         Description :从Android P开始，只有当Intent flag中指定了FLAG_ACTIVITY_NEW_TASK，才允许在非Activity场景启动Activity。
 *         Change : YangHaoYi on 2018/8/2.
 *         Version : V 1.0
 */
public class ToActivityService extends Service{

    @Override
    public void onCreate() {
        super.onCreate();
        Intent intent = new Intent(this, HomeActivity.class);
        //不加 FLAG_ACTIVITY_NEW_TASK 将抛出异常
        //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
