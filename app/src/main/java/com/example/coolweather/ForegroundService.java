package com.example.coolweather;




import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

import java.util.Calendar;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class ForegroundService extends Service {

        private static final int NOTIFICATION_ID = 1;
        private static final String NOTIFICATION_CHANNEL_ID = "example.service.channel";
        private static final String NOTIFICATION_CHANNEL_NAME = "Example Service Channel";

        @Override
        public void onCreate() {
            super.onCreate();

            // 创建通知渠道
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                NotificationChannel channel = new NotificationChannel(NOTIFICATION_CHANNEL_ID,
                        NOTIFICATION_CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
                NotificationManager manager = getSystemService(NotificationManager.class);
                if (manager != null) {
                    manager.createNotificationChannel(channel);
                }
            }

            // 创建通知并将服务设置为前台服务
            Notification notification = createNotification();
            startForeground(NOTIFICATION_ID, notification);
        }

        private Notification createNotification() {
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID);
            builder.setSmallIcon(R.drawable.locate)
                    .setContentTitle("CoolWeather正在运行")
                    .setContentText("嗨你好")
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT);

            return builder.build();
        }

        @Nullable
        @Override
        public IBinder onBind(Intent intent) {
            return null;
        }
    }