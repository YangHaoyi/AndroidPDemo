package com.yanghaoyi.androidpdemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;

import com.yanghaoyi.androidpdemo.R;

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
    }

    private void initEvent(){
        tvToForeground.setOnClickListener(this);
        tvToBroadCast.setOnClickListener(this);
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
            default:
                break;
        }
    }
}
