package com.example.administrator.typefacesize;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private static final String fileName = "sharedziti";// 定义保存的文件的名称
    @BindView(R.id.setting_Size)
    Button settingSize;
    private float zt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_typefacesizw);
        ButterKnife.bind(this);
        initFontScale();
    }

    private void initFontScale() {


        SharedPreferences spCount = getSharedPreferences(fileName, Context.MODE_PRIVATE);
        zt = spCount.getFloat("zt", 1.0f);

//        zt = spCount.getFloat("zt", Float.parseFloat("f"));
        if (zt < 1.0f) {
            zt = 1.0f;
        }
        Configuration configuration = getResources().getConfiguration();
        configuration.fontScale = zt;
        //0.85 小, 1 标准大小, 1.15 大，1.3 超大 ，1.45 特大
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        metrics.scaledDensity = configuration.fontScale * metrics.density;
        getBaseContext().getResources().updateConfiguration(configuration, metrics);
    }
    @OnClick(R.id.setting_Size)
    public void onViewClicked() {
        startActivity(new Intent(this, FontSizeAcivity.class));
    }
}