package cn.itcast.chat;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by User on 2017/1/14.
 */
public class XinWenFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView tv= new TextView(getActivity());
        tv.setText("新闻");
        tv.setTextColor(Color.BLACK);
        tv.setTextSize(24);
        return tv;
    }
}
