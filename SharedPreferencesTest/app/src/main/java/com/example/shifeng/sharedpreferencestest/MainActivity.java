package com.example.shifeng.sharedpreferencestest;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ShareActionProvider;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 以下是保存数据按钮
        Button saveData = (Button) findViewById(R.id.save_data);
        saveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
                editor.putString("name", "hello");
                editor.putInt("age", 4);
                editor.apply();
                Toast.makeText(MainActivity.this, "保存完成", Toast.LENGTH_SHORT).show();
            }
        });

        // 以下是读取数据按钮
        Button readData = (Button) findViewById(R.id.read_data);
        readData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = getSharedPreferences("data", MODE_PRIVATE);
                String name = pref.getString("name", "");
                int age = pref.getInt("age", 0);
                Toast.makeText(MainActivity.this, "name is " + name + " and age is " + age, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
