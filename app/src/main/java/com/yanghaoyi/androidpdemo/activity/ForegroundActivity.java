package com.yanghaoyi.androidpdemo.activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.yanghaoyi.androidpdemo.R;
import com.yanghaoyi.androidpdemo.service.ForegroundService;

/**
 * @author : YangHaoYi on 2018/8/1.
 *         Email  :  yang.haoyi@qq.com
 *         Description :在安卓P版本之后，必须要授予FOREGROUND_SERVICE权限，才能够使用前台服务，否则会抛出异常。
 *         Change : YangHaoYi on 2018/8/1.
 *         Version : V 1.0
 */
public class ForegroundActivity extends FragmentActivity{

    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName className, IBinder service) {

        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {

        }
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foreground);
        Intent intent = new Intent(this, ForegroundService.class);
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(mConnection);
    }
}
