package com.example.shifeng.broadcasttest;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private IntentFilter intentFilter;
    private IntentFilter myIntentFilter;

    private NetworkChangeReceiver networkChangeReceiver;
    private MyBroadcastReceiver myBroadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intentFilter = new IntentFilter();                              // 创建IntentFilter实例
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE"); // 添加 android.net.conn.CONNECTIVITY_CHANGE 监听action为网络发生变化的广播
        networkChangeReceiver = new NetworkChangeReceiver();            // 创建 NetworkChangeReceiver 实例
        registerReceiver(networkChangeReceiver, intentFilter);          // 进行注册，完成监听功能

        myIntentFilter = new IntentFilter();
        myIntentFilter.addAction("com.example.MY_BROADCAST");
        myBroadcastReceiver = new MyBroadcastReceiver();
        registerReceiver(myBroadcastReceiver, myIntentFilter);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.MY_BROADCAST");
                sendBroadcast(intent);
            }
        });
    }

    // 在活动销毁周期，注销掉已注册的监听，动态注册的必做此步骤
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(networkChangeReceiver);
        unregisterReceiver(myBroadcastReceiver);
    }
}
