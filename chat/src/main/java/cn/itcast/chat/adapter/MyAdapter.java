package cn.itcast.chat.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.itcast.chat.R;
import cn.itcast.chat.bean.BlogsBean;

/**
 * Created by User on 2017/1/14.
 */

public class MyAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private List<BlogsBean> mBeanList = new ArrayList<>();
    public MyAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        BlogsBean blogsBean = mBeanList.get(position);
        viewHolder.mTitle.setText(blogsBean.blog.get(position).title);
        viewHolder.mDes.setText(blogsBean.blog.get(position).authorname);
        viewHolder.mTime.setText(blogsBean.blog.get(position).pubDate);
    }

    @Override
    public int getItemCount() {
        return mBeanList==null?null:mBeanList.size();
    }
    static class ViewHolder extends  RecyclerView.ViewHolder{
        @BindView(R.id.title)
        TextView mTitle;
        @BindView(R.id.des)
        TextView mDes;
        @BindView(R.id.time)
        TextView mTime;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
