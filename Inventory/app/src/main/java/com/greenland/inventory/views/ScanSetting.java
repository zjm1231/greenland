package com.greenland.inventory.views;

import android.os.Vibrator;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.greenland.inventory.R;

import cn.bingoogolapple.qrcode.core.QRCodeView;
import cn.bingoogolapple.qrcode.zxing.ZXingView;

public class ScanSetting extends BaseActivity implements QRCodeView.Delegate {
    EditText etResult;
    ZXingView zXingView;

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

        etResult = findViewById(R.id.et_scansetting_result);

        Button btnSave = findViewById(R.id.btn_scansetting_save);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        zXingView = findViewById(R.id.zxingview);
        zXingView.setDelegate(this);
        zXingView.startSpotAndShowRect();
    }

    @Override
    public void initData() {

    }

    @Override
    public void onScanQRCodeSuccess(String result) {
        Toast.makeText(this, "扫描成功", Toast.LENGTH_SHORT).show();
        etResult.setText(result);
        vibrate();

        zXingView.stopSpot();
        zXingView.stopCamera();
    }

    @Override
    public void onScanQRCodeOpenCameraError() {
        Toast.makeText(this, "打开相机出错", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        zXingView.startCamera(0);
        zXingView.startCamera();
    }

    @Override
    protected void onStop() {
        zXingView.stopCamera();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        zXingView.onDestroy();
        super.onDestroy();
    }

    private void vibrate() {
        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        vibrator.vibrate(200);
    }


}
