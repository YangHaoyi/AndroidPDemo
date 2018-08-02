package com.yanghaoyi.androidpdemo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;

import com.yanghaoyi.androidpdemo.R;
import com.yanghaoyi.androidpdemo.event.BackgroundEvent;

import org.greenrobot.eventbus.EventBus;

/**
 * @author : YangHaoYi on 2018/8/2.
 *         Email  :  yang.haoyi@qq.com
 *         Description :
 *         Change : YangHaoYi on 2018/8/2.
 *         Version : V 1.0
 */
public class BackGroundStartServiceActivity extends FragmentActivity implements View.OnClickListener {

    private TextView tvSendEventBus;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_background_start_service);
        init();
    }

    private void init(){
        initView();
        initEvent();
    }

    private void initView(){
        tvSendEventBus = findViewById(R.id.tvSendEventBus);
    }

    private void initEvent(){
        tvSendEventBus.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tvSendEventBus:
                EventBus.getDefault().post(new BackgroundEvent().setStartService(true));
                break;
        }
    }
}
