package cn.itcast.chat;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TextView;

import java.util.ArrayList;

import entity.MainTab;

/**
 * Created by User on 2017/1/13.
 */

public class SelectTitleActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ViewPager mViewPager;
    private ArrayList<String> mTitle1;
    private ArrayList<View> mViews;
    private FragmentTabHost mTabHost;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
       // TextView textView = new TextView(this);
        //init();
        //init1();
        init2();
    }

    private void init2() {
        MainTab[] values = MainTab.values();
        for (int i = 0; i< values.length; i++){
            MainTab mainTab = values[i];
            String title = mainTab.getTitle();
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(mainTab.getTag());
            tabSpec.setIndicator(title);
            Bundle bundle = new Bundle();
            bundle.putString("key",mainTab.getTitle());
            mTabHost.addTab(tabSpec,mainTab.getClz(),bundle);
        }
    }

    private void init1() {
        mTabHost = (FragmentTabHost) findViewById(R.id.TabHost);

        mTabHost.setup(getApplicationContext(),getSupportFragmentManager(),R.id.tv_host);
        TabHost.TabSpec  tabSpec = mTabHost.newTabSpec("news");
        tabSpec.setIndicator("综合");//设置视图
        Bundle bundle = new Bundle();
        bundle.putString("key","我的综合");
        mTabHost.addTab(tabSpec,DDDDD.class,bundle);
    }

    private void init() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayou);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        View view1 = getLayoutInflater().inflate(R.layout.layou1, null);
        mViews = new ArrayList<>();
        //  View view2 = getLayoutInflater().inflate(R.layout.layou2, null);
        View view2 = LayoutInflater.from(this).inflate(R.layout.layou2, null);
        mViews.add(view1);
        mViews.add(view2);
        mTitle1 = new ArrayList<>();
        mTitle1.add("吕成欢");
        mTitle1.add("常碧发");
        PagerAdapter mMAdapter  =  new PagerAdapter() {

            @Override
            public int getCount() {
                return mViews.size();
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(mViews.get(position));
                return mViews.get(position);
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view==object;
            }

            @Override
            public void destroyItem(ViewGroup container,
                                    int position, Object object) {
                super.destroyItem(container, position, object);
                container.removeView((View) object);
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return mTitle1.get(position);
            }
        };
        mViewPager.setAdapter(mMAdapter);
    }
}
