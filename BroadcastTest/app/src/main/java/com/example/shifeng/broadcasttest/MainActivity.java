package com.example.shifeng.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private IntentFilter intentFilter;

    private NetworkChangeReceiver networkChangeReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intentFilter = new IntentFilter();                              // 创建IntentFilter实例
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE"); // 添加 android.net.conn.CONNECTIVITY_CHANGE 监听action为网络发生变化的广播
        networkChangeReceiver = new NetworkChangeReceiver();            // 创建 NetworkChangeReceiver 实例
        registerReceiver(networkChangeReceiver, intentFilter);          // 进行注册，完成监听功能
    }

    // 在活动销毁周期，注销掉已注册的监听，动态注册的必做此步骤
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(networkChangeReceiver);
    }

    // 定义内部类NetworkChangeReceiver 继承自 BroadcastReceiver 广播，每当有广播来就触发onReceive执行方法内语句
    class NetworkChangeReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
//            Toast.makeText(context, "network changes", Toast.LENGTH_SHORT).show();

            // 获取系统服务类的实例 getSystemService
            ConnectivityManager connectionManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
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
}
