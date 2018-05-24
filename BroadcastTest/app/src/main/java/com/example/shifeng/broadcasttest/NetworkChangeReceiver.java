package com.example.shifeng.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class NetworkChangeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
//            Toast.makeText(context, "network changes", Toast.LENGTH_SHORT).show();

        // 获取系统服务类的实例 getSystemService
        ConnectivityManager connectionManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        // 获取 NetworkInfo 实例
        NetworkInfo networkInfo = connectionManager.getActiveNetworkInfo();
        // 用NetworkInfo实例下的方法isAvailable()是否开启进行判断输出
        if (networkInfo != null && networkInfo.isAvailable()) {
            Toast.makeText(context, "network is available",
                    Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "network is unavailable", Toast.LENGTH_SHORT).show();
        }
    }
}