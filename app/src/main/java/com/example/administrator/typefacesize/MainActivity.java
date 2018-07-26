package com.example.administrator.typefacesize;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.setting_Size)
    Button settingSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_typefacesizw);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.setting_Size)
    public void onViewClicked() {
        startActivity(new Intent(this, FontSizeAcivity.class));
    }
}
