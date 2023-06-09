package com.example.coolweather;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * 广播接收者的使用
 * 这里使用的是静态注册的方法，等待接收广播
 */

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("Receiver", "这是静态的广播接受者（优先级500）---》" + intent.getStringExtra("msg"));
        Toast.makeText(context, "按返回键可停止等待", Toast.LENGTH_SHORT).show();
        abortBroadcast();
    }
}