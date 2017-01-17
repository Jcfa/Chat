package cn.itcast.chat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Vibrator;
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

import cn.bingoogolapple.qrcode.core.QRCodeView;
import cn.bingoogolapple.qrcode.zxing.ZXingView;

public class MainActivity extends AppCompatActivity implements QRCodeView.Delegate {
    private static final String TAG = "tag";
    private QRCodeView mQRCodeView;
    private Object IntentKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mQRCodeView = (ZXingView) findViewById(R.id.zxingview);
        mQRCodeView.startSpot();
        mQRCodeView.setResultHandler(this);
        mQRCodeView.startSpot();//
        mQRCodeView.startCamera();//
        mQRCodeView.startSpotAndShowRect();//

    }
  /*  public void onClick(View view){
        Intent intent = new Intent(this,SelectTitleActivity.class);
        startActivity(intent);
    }
*/


    @Override//成功的方法
    public void onScanQRCodeSuccess(String result) {
        if (result.contains("csdn.net")) {
             //startWebViewForResult(result, true, "", IntentKey.BACK);
            vibrate();
        }
        mQRCodeView.startCamera();
        mQRCodeView.startSpot();

    }
    //设置二维码
    private void vibrate() {
        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        vibrator.vibrate(200);
    }
    @Override//失败的方法
    public void onScanQRCodeOpenCameraError() {
        Log.e(TAG, "打开相机出错");
    }
}
