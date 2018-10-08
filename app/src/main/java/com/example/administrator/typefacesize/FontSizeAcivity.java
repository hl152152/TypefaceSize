package com.example.administrator.typefacesize;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.administrator.typefacesize.util.SetTextSizeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * _oo0oo_
 * o8888888o
 * 88" . "88
 * (| -_- |)
 * 0\  =  /0
 * ___/`---'\___
 * .' \\|     |// '.
 * / \\|||  :  |||// \
 * / _||||| -卍-|||||- \
 * |   | \\\  -  /// |   |
 * | \_|  ''\---/''  |_/ |
 * \  .-\__  '-'  ___/-. /
 * ___'. .'  /--.--\  `. .'___
 * ."" '<  `.___\_<|>_/___.' >' "".
 * | | :  `- \`.;`\ _ /`;.`/ - ` : | |
 * \  \ `_.   \_ __\ /__ _/   .-` /  /
 * =====`-.____`.___ \_____/___.-`___.-'=====
 * `=---='
 * 佛祖保佑        永无BUG
 * 佛曰:
 * 程序园里程序天，程序天里程序员；
 * 程序猿人写程序，又拿程序换肉钱。
 * 肉饱继续桌前坐，饱暖还是桌前眠；
 * 半迷半醒日复日，码上码下年复年。
 * 但愿叱咤互联世，不愿搬砖码当前；
 * 诸葛周瑜算世事，我来算出得加钱。
 * 别人笑我忒直男，我笑自己太像猿；
 * 但见成都府国内，处处地地程序员。
 * Created by HCJ
 * ${DATA}
 */
public class FontSizeAcivity extends Activity {


    private static final String fileName = "sharedziti";// 定义保存的文件的名称

    @BindView(R.id.set_size)
    SetTextSizeView setSize;
    @BindView(R.id.content)
    LinearLayout content;
    @BindView(R.id.fontsize_qx)
    Button fontsizeQx;
    @BindView(R.id.fontsize_sure)
    Button fontsizeSure;

    public int fontSzie;
    private float ztSize = 1;

    /**
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        setSize.setOnPointResultListener(new SetTextSizeView.OnPointResultListener() {
            @Override
            public void onPointResult(int position) {
//                setSize.setTextAlignment(position + 1);
                fontSzie = position + 1;

                if (fontSzie == 1) {//小号字体
                    ztSize = 0.85f;
                } else if (fontSzie == 2) {//标准字体
                    ztSize = 1.0f;
                } else if (fontSzie == 3) {//中号字体
                    ztSize = 1.3f;
                } else if (fontSzie == 4) {//大号字体
                    ztSize = 1.5f;
                } else if (fontSzie == 5) {//超大字体
                    ztSize = 1.7f;
                } else if (fontSzie == 6) {//巨大字体
                    ztSize = 2f;
                }

                initFontScale();

            }

        });
    }


    private void initFontScale() {

        Configuration configuration = getResources().getConfiguration();
        configuration.fontScale = ztSize;
        //0.85 小, 1 标准大小, 1.15 大，1.3 超大 ，1.45 特大
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        metrics.scaledDensity = configuration.fontScale * metrics.density;
        getBaseContext().getResources().updateConfiguration(configuration, metrics);
    }


    @OnClick({R.id.set_size, R.id.content, R.id.fontsize_qx, R.id.fontsize_sure})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.set_size:
                break;
            case R.id.fontsize_qx:
                setSize.clearFocus();
                finish();
                break;
            case R.id.fontsize_sure:
                Log.d("TAG", "onViewClicked: " + ztSize);

                if (ztSize == 0.0f) {
                    Toast.makeText(this, "请设置字体大小", Toast.LENGTH_SHORT).show();
                } else {
                    float zt = ztSize;
                    SharedPreferences spCount = getApplication().getSharedPreferences(fileName, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = spCount.edit();
                    editor.putFloat("zt", zt);
                    editor.commit();
                    startActivity(new Intent(this, MainActivity.class));


                }


                break;
        }
    }
}
