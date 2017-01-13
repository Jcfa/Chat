package cn.itcast.chat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by User on 2017/1/13.
 */

public class DDDDD extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        textView.setTextColor(Color.BLACK);
      //  Intent intent = getActivity().getIntent();
        //String key = intent.getStringExtra("key");
        String key = getArguments().getString("news");
        textView.setText(key);
        return textView;
    }
}
