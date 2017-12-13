package com.greenland.inventory.views;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.greenland.inventory.R;

public class MainActivity extends BaseActivity {
    @Override
    public void setContentView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    public void initView() {
        RadioGroup rg = findViewById(R.id.rdg_login);
        rg.check(R.id.rdb_login_online);

        Button btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "点击了登录按钮", Toast.LENGTH_SHORT).show();
            }
        });

        TextView tvScan = findViewById(R.id.tv_main_scansetting);
        tvScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ScanSetting.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void initData() {

    }

}
