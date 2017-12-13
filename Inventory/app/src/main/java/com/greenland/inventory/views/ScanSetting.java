package com.greenland.inventory.views;

import android.support.v7.widget.Toolbar;
import android.view.View;

import com.greenland.inventory.R;

public class ScanSetting extends BaseActivity {

    @Override
    public void setContentView() {
        setContentView(R.layout.activity_scan_setting);
    }

    @Override
    public void initView() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void initData() {

    }
}
