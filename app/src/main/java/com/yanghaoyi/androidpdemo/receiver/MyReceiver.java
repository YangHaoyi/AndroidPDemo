package com.yanghaoyi.androidpdemo.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * @author : YangHaoYi on 2018/8/1.
 *         Email  :  yang.haoyi@qq.com
 *         Description :
 *         Change : YangHaoYi on 2018/8/1.
 *         Version : V 1.0
 */
public class MyReceiver extends BroadcastReceiver{

    private static final String TOAST_ACTION = "com.yanghaoyi.Update";

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if(TOAST_ACTION.equals(action)){
            Toast.makeText(context,"接收到广播",Toast.LENGTH_LONG).show();
        }
    }
}
