package com.grandstream.jfdeng.minedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mIconImg;
    private Button mStart;
    private Button mSetting;
    private Button mOther;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mIconImg = (ImageView) findViewById(R.id.iconImg);
        mStart = (Button) findViewById(R.id.start);
        mSetting = (Button) findViewById(R.id.setting);
        mOther = (Button) findViewById(R.id.other);

        mStart.setOnClickListener(this);
        mSetting.setOnClickListener(this);
        mOther.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start:
                startActivity(new Intent(this,GameActivity.class));
                break;
            case R.id.setting:

                break;
            case R.id.other:

                break;
        }
    }
}
