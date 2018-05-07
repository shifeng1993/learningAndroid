package com.example.shifeng.androidstart;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.hide();
        }
        if (savedInstanceState != null) {
            String tmpData = savedInstanceState.getString("data_key");
            Log.d("printData", tmpData);
        }
        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "HELLO IS ME", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String tmpData = "hello is me";
        outState.putString("data_key", tmpData);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("onStart", "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("onStop", "onStop");
    }
}
