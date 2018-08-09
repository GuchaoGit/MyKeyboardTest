package com.guc.mykeyboardtest;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import com.guc.mykeyboardtest.widget.KeyBoardCarNumberUtil;

public class MainActivity extends AppCompatActivity {
    private EditText mEtInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEtInput = findViewById(R.id.et_input);
        mEtInput.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                KeyBoardCarNumberUtil.showKeyBoard(MainActivity.this,mEtInput);
                return false;
            }
        });

        //点击不弹出系统软键盘
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mEtInput.setShowSoftInputOnFocus(false);
        }
    }

    @Override
    public void onBackPressed() {
        if (KeyBoardCarNumberUtil.isShowing()) {
            KeyBoardCarNumberUtil.hideKeyBoard();
        } else {
            super.onBackPressed();
        }
    }
}
