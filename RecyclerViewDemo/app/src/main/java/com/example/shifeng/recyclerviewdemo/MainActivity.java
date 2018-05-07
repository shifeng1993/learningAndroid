package com.example.shifeng.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();                                                                // 初始化水果数据
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view); // 获取RecyclerView实例
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);    // 创建layoutManager对象，
        recyclerView.setLayoutManager(layoutManager);                                // 指定布局方式
        FruitAdapter adapter = new FruitAdapter(fruitList);                          // list数据传到适配器中
        recyclerView.setAdapter(adapter);                                            // 完成适配器设置
    }
    // mock一个列表
    private void initFruits() {
        for (int i = 0; i < 100; i++) {
            Fruit apple = new Fruit("Apple", R.drawable.ic_accessibility_black_24dp);
            fruitList.add(apple);
            Fruit banana = new Fruit("Banana", R.drawable.ic_accessibility_black_24dp);
            fruitList.add(banana);
            Fruit orange = new Fruit("Orange", R.drawable.ic_accessibility_black_24dp);
            fruitList.add(orange);
            Fruit watermelon = new Fruit("Watermelon", R.drawable.ic_accessibility_black_24dp);
            fruitList.add(watermelon);
            Fruit pear = new Fruit("Pear", R.drawable.ic_accessibility_black_24dp);
            fruitList.add(pear);
            Fruit grape = new Fruit("Grape", R.drawable.ic_accessibility_black_24dp);
            fruitList.add(grape);
            Fruit pineapple = new Fruit("Pineapple", R.drawable.ic_accessibility_black_24dp);
            fruitList.add(pineapple);
            Fruit strawberry = new Fruit("Strawberry", R.drawable.ic_accessibility_black_24dp);
            fruitList.add(strawberry);
            Fruit cherry = new Fruit("Cherry", R.drawable.ic_accessibility_black_24dp);
            fruitList.add(cherry);
            Fruit mango = new Fruit("Mango", R.drawable.ic_accessibility_black_24dp);
            fruitList.add(mango);
        }
    }
}
