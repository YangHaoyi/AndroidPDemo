package com.yanghaoyi.androidpdemo.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.yanghaoyi.androidpdemo.R;

import java.lang.reflect.Field;

/**
 * @author : YangHaoYi on 2018/8/2.
 *         Email  :  yang.haoyi@qq.com
 *         Description :在 Android P 版本中，谷歌加入了非 SDK 接口使用限制，无论是通过调用、反射还是JNI等方式，开发者都无法对非 SDK 接口进行访问
 *         Change : YangHaoYi on 2018/8/2.
 *         Version : V 1.0
 */
public class NotSDKInterfaceActivity extends FragmentActivity implements View.OnClickListener {

    private TextView tvShowDialog;
    private AlertDialog normalDialog;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_not_sdk_interface);
        init();
    }

    private void init(){
        initView();
        initEvent();
    }

    private void initView(){
        tvShowDialog = findViewById(R.id.tvShowDialog);
    }

    private void initEvent(){
        tvShowDialog.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tvShowDialog:
                showNormalDialog();
                break;
            default:
                break;
        }
    }

    private void showNormalDialog(){
            /* @setIcon 设置对话框图标
     * @setTitle 设置对话框标题
     * @setMessage 设置对话框消息提示
     * setXXX方法返回Dialog对象，因此可以链式设置属性
     */
        if (normalDialog == null) {
            normalDialog = new AlertDialog.Builder(NotSDKInterfaceActivity.this).setPositiveButton("确定",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //...To-do

                        }
                    }).setNegativeButton("取消",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //...To-do

                        }
                    }).create();
        }
        normalDialog.setCancelable(false);
        normalDialog.setTitle("非SDK接口测试");
        normalDialog.setMessage("通过反射修改Dialog字体");
        // 显示
        normalDialog.show();
        normalDialog.getButton(android.app.AlertDialog.BUTTON_POSITIVE).setTextSize(20);
        normalDialog.getButton(android.app.AlertDialog.BUTTON_NEGATIVE).setTextSize(20);
        try {
            //通过反射的方式来更改dialog中文字大小、颜色
            Field mAlert = AlertDialog.class.getDeclaredField("mAlert");
            mAlert.setAccessible(true);
            Object mAlertController = mAlert.get(normalDialog);

            Field mMessage = mAlertController.getClass().getDeclaredField("mMessageView");
            mMessage.setAccessible(true);
            TextView mMessageView = (TextView) mMessage.get(mAlertController);
            mMessageView.setTextSize(23);
            mMessageView.setTextColor(Color.RED);
            Field mTitle = mAlertController.getClass().getDeclaredField("mTitleView");
            mTitle.setAccessible(true);
            TextView mTitleView = (TextView) mTitle.get(mAlertController);
            mTitleView.setTextSize(20);
            mTitleView.setTextColor(Color.RED);
        }catch (Exception e){
            Toast.makeText(NotSDKInterfaceActivity.this,e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
        }
    }

}
