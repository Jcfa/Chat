package cn.itcast.chat;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private int srceenHeight;
    private int srceenWidth;
    private ViewPager mViewPager;
    private PagerAdapter mMAdapter;
    private List<View> mViews;
    private PagerTabStrip mTabStrip;
    private List<String> mTitle1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
       // init1();

    }
    public void onClick(View view){
        Intent intent = new Intent(this,SelectTitleActivity.class);
        startActivity(intent);
    }

    private void init1() {
        // init();
        //mViewPager = (ViewPager) findViewById(R.id.viewPager);
       // mTabStrip = (PagerTabStrip) findViewById(R.id.viewPager_strip);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("你好了");

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.actionbar_back_icon_normal);
        mViews = new ArrayList<>();
        //  View inflate = getLayoutInflater().inflate(R.layout.layou1, null);
        View view1 = getLayoutInflater().inflate(R.layout.layou1, null);
        //  View view2 = getLayoutInflater().inflate(R.layout.layou2, null);
        View view2 = LayoutInflater.from(this).inflate(R.layout.layou2, null);
        mTabStrip.setDrawFullUnderline(false);
        mTabStrip.getTabIndicatorColor();
        mTabStrip.setTabIndicatorColor(Color.YELLOW);
        mTabStrip.setTextSpacing(200);
        mTabStrip.animate().scaleX(0.5f).scaleY(0.5f);
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }

    private void init() {
       // TextView textView = (TextView) findViewById(R.id.tv);
        //找到父控件
        DisplayMetrics metrics = new DisplayMetrics();
        //设置当前屏幕的宽高像素
        getWindowManager().getDefaultDisplay().getRealMetrics(metrics);
        //获取屏幕宽高
        srceenWidth =  metrics.widthPixels;
        srceenHeight =  metrics.heightPixels;
        Log.d("cbf","srceenWidth="+srceenWidth+"srceenHeight="+srceenHeight);
        RelativeLayout.LayoutParams params = new
                RelativeLayout.LayoutParams(srceenWidth,srceenHeight);
        //textView.setLayoutParams(params);
    }

}
