package cn.itcast.chat;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 2017/1/12.
 */
public class MAdapater  extends FragmentPagerAdapter{
    private List<Fragment> mViews = new ArrayList<>();

    public MAdapater(FragmentManager fm,List<Fragment> mViews) {
        super(fm);
        this.mViews = mViews;
    }

    @Override
    public Fragment getItem(int position) {
        return mViews.get(position);
    }

    @Override
    public int getCount() {
        return mViews.size();
    }
}
