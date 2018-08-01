package com.yanghaoyi.androidpdemo.activity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;

import com.yanghaoyi.androidpdemo.R;
import com.yanghaoyi.androidpdemo.receiver.MyReceiver;

/**
 * @author : YangHaoYi on 2018/8/1.
 *         Email  :  yang.haoyi@qq.com
 *         Description :
 *         Change : YangHaoYi on 2018/8/1.
 *         Version : V 1.0
 */
public class BroadCastActivity extends FragmentActivity implements View.OnClickListener {

    private static final String TOAST_ACTION = "com.yanghaoyi.Update";
    private MyReceiver myReceiver;
    private TextView tvSendBroadCast;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);
        init();
    }

    private void init(){
        initView();
        initEvent();
    }

    private void initView(){
        tvSendBroadCast = findViewById(R.id.tvSendBroadCast);
    }

    private void initEvent(){
        registerReceiver();
        tvSendBroadCast.setOnClickListener(this);
    }

    private void registerReceiver(){
        myReceiver = new MyReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TOAST_ACTION);
        registerReceiver(myReceiver, intentFilter);
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myReceiver);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tvSendBroadCast:
                Intent intent = new Intent();
                intent.setAction(TOAST_ACTION);
                sendBroadcast(intent);
                break;
        }
    }
}
