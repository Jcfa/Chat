package cn.itcast.chat;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListAdapter;
import android.widget.ListView;

import cn.itcast.chat.adapter.MyAdapter;


/**
 * 二维码扫描
 */

public class SelectTitleActivity extends AppCompatActivity {

    private ListView mLv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        mLv = (ListView) findViewById(R.id.lv);
        MyAdapter adapater = new MyAdapter(this);
        mLv.setAdapter((ListAdapter) adapater);

    }
}
