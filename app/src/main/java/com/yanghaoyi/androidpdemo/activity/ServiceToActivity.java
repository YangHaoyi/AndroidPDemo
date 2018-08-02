package com.yanghaoyi.androidpdemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;

import com.yanghaoyi.androidpdemo.R;
import com.yanghaoyi.androidpdemo.service.ToActivityService;

/**
 * @author : YangHaoYi on 2018/8/2.
 *         Email  :  yang.haoyi@qq.com
 *         Description :从Android P开始，只有当Intent flag中指定了FLAG_ACTIVITY_NEW_TASK，才允许在非Activity场景启动Activity。
 *         Change : YangHaoYi on 2018/8/2.
 *         Version : V 1.0
 */
public class ServiceToActivity extends FragmentActivity implements View.OnClickListener {


    private TextView tvStartService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.serviceto_activity);
        init();
    }

    private void init(){
        initView();
        initEvent();
    }

    private void initView(){
        tvStartService = findViewById(R.id.tvStartService);
    }

    private void initEvent(){
        tvStartService.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tvStartService:
                Intent intent = new Intent(this, ToActivityService.class);
                startService(intent);
                break;
            default:
                break;
        }
    }
}
