package com.yanghaoyi.androidpdemo.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;

import com.yanghaoyi.androidpdemo.R;
import com.yanghaoyi.androidpdemo.activity.ForegroundActivity;

/**
 * @author : YangHaoYi on 2018/8/1.
 *         Email  :  yang.haoyi@qq.com
 *         Description :在安卓P版本之后，必须要授予FOREGROUND_SERVICE权限，才能够使用前台服务，否则会抛出异常。
 *         Change : YangHaoYi on 2018/8/1.
 *         Version : V 1.0
 */
public class ForegroundService extends Service{

    @Override
    public void onCreate() {
        super.onCreate();
        String channelID = "1";
        String channelName = "channel_name";
        NotificationChannel channel = new NotificationChannel(channelID, channelName, NotificationManager.IMPORTANCE_HIGH);
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.createNotificationChannel(channel);
        Intent intent = new Intent(this, ForegroundActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);
        Notification notification = new NotificationCompat.Builder(this)
                .setContentTitle("前台服务测试")
                .setContentText("前台服务需要增加 FOREGROUND_SERVICE 权限")
                .setChannelId(channelID)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                .setContentIntent(pi)
                .build();
        startForeground(1, notification);
    }


    private LocalBinder mBinder = new LocalBinder();

    public class LocalBinder extends Binder {

        public ForegroundService getService() {
            return ForegroundService.this;
        }

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }
}
