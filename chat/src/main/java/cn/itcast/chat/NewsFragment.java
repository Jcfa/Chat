package cn.itcast.chat;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by User on 2017/1/14.
 */

public class NewsFragment extends Fragment {
    @BindView(R.id.tablelayou)
    TabLayout mTablelayou;
    @BindView(R.id.viewPager)
    ViewPager mViewPager;
    private NewsAdapter mAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View fragmentView =
                inflater.inflate(R.layout.activity_tableyout, container, false);
        ButterKnife.bind(this, fragmentView);
        //这里使用这个是因为  如果布局是嵌套的话
        mAdapter = new NewsAdapter(getChildFragmentManager());

        //将数据适配器设置给ViewPager
        mViewPager.setAdapter(mAdapter);

        //进行关联
        mTablelayou.setupWithViewPager(mViewPager);

        //初始化viewPager显示的数据
        //还有TableLayout数据的设置  标签
        // 信息
        mTablelayou.setTabMode(TabLayout.MODE_FIXED);
        mTablelayou.addTab(mTablelayou.newTab().setText("资信"));
        mTablelayou.addTab(mTablelayou.newTab().setText("新闻"));
        mTablelayou.addTab(mTablelayou.newTab().setText("资料"));

        //向viewPager
        mAdapter.addFragment(new ZiXinFragment());
        mAdapter.addFragment(new XinWenFragment());
        mAdapter.addFragment(new ZILIANFragment());
        return fragmentView;
    }

    //动态的保存状态
    public class NewsAdapter extends FragmentStatePagerAdapter {
        private List<Fragment> mFragments = new ArrayList<>();
        public void addFragment(Fragment fragment){
            mFragments.add(fragment);
            notifyDataSetChanged();
        }
        public NewsAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments==null?null:mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return super.getPageTitle(position);
        }
    }
}
