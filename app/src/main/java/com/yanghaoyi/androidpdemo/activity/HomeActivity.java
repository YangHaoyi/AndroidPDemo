package com.yanghaoyi.androidpdemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;

import com.yanghaoyi.androidpdemo.R;
import com.yanghaoyi.androidpdemo.event.BackgroundEvent;
import com.yanghaoyi.androidpdemo.service.BackgroundService;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * @author : YangHaoYi on 2018/8/1.
 *         Email  :  yang.haoyi@qq.com
 *         Description :
 *         Change : YangHaoYi on 2018/8/1.
 *         Version : V 1.0
 */
public class HomeActivity extends FragmentActivity implements View.OnClickListener {

    private TextView tvToForeground;
    private TextView tvToBroadCast;
    private TextView tvToDialog;
    private TextView tvToServiceToActivity;
    private TextView tvToBackgroundStartService;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
    }

    private void init(){
        initView();
        initEvent();
    }

    private void initView(){
        tvToBroadCast = findViewById(R.id.tvToBroadCast);
        tvToForeground = findViewById(R.id.tvToForeground);
        tvToDialog = findViewById(R.id.tvToDialog);
        tvToServiceToActivity = findViewById(R.id.tvToServiceToActivity);
        tvToBackgroundStartService = findViewById(R.id.tvToBackgroundStartService);
    }

    private void initEvent(){
        EventBus.getDefault().register(this);
        tvToForeground.setOnClickListener(this);
        tvToBroadCast.setOnClickListener(this);
        tvToDialog.setOnClickListener(this);
        tvToServiceToActivity.setOnClickListener(this);
        tvToBackgroundStartService.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.tvToForeground:
                intent = new Intent(HomeActivity.this,ForegroundActivity.class);
                startActivity(intent);
                break;
            case R.id.tvToBroadCast:
                intent = new Intent(HomeActivity.this,BroadCastActivity.class);
                startActivity(intent);
                break;
            case R.id.tvToDialog:
                intent = new Intent(HomeActivity.this,DialogActivity.class);
                startActivity(intent);
                break;
            case R.id.tvToServiceToActivity:
                intent = new Intent(HomeActivity.this,ServiceToActivity.class);
                startActivity(intent);
                break;
            case R.id.tvToBackgroundStartService:
                intent = new Intent(HomeActivity.this,BackGroundStartServiceActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    @Subscribe
    public void startServiceEvent(BackgroundEvent backgroundEvent){
        if(backgroundEvent.isStartService()){
            Intent intent = new Intent(HomeActivity.this, BackgroundService.class);
            startService(intent);
        }
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
