package com.example.shifeng.androidstart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class showLog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_log);
        Log.d("showLog", "hello isme");
    }
}
