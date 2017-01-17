package cn.csxw.actionbardemo;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ActionBar mActionBar;
    private WebView mWebView;
    private WebView mView;
    private TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mView = (WebView) findViewById(R.id.webView);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        initActionBar();
        initData();
    }

    private void initData() {
       /* //创建ＶｅｂＶｉｅｗ对象
        mWebView = new WebView(this);*/
        //支持javaScript脚本  不写就展示不出来
        mView.getSettings().setJavaScriptEnabled(true);
        mView.loadUrl("http://liangruijun.blog.51cto.com/3061169/647456/");
        //这是webView视图 也就是要展示的视图
        mView.setWebViewClient(new HelloViewClient());
        mView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                tvTitle.setText("加载完成"+newProgress);
            }
        });
    }
    private class HelloViewClient extends   WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl("http://www.51cto.com/");
            return true;
        }

    }

    private void initActionBar() {
        //获取ActionBar
        mActionBar = getSupportActionBar();
        mActionBar.setHomeAsUpIndicator(R.drawable.ic_brows_back);
        mActionBar.setTitle("点击退出");
        //设置为图标可见
        mActionBar.setDisplayHomeAsUpEnabled(true);
        //设置logo
        mActionBar.setHomeButtonEnabled(true);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //如果按返回键 就直接退出这个界面  不然？
        if ((keyCode==KeyEvent.KEYCODE_BACK)&&mWebView.canGoBack()){
            mWebView.goBack();
            return true;
        }
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
               if (mActionBar!=null){
                   finish();
               }
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
