package com.android.ct7liang.canvasdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.android.ct7liang.canvasdemo.newView.SignView01;

public class Main3Activity extends AppCompatActivity {

    private SignView01 signView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        signView = findViewById(R.id.sign_view);

        findViewById(R.id.view_r).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signView.setPColor(1);
            }
        });
        findViewById(R.id.view_g).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signView.setPColor(2);
            }
        });
        findViewById(R.id.view_b).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signView.setPColor(0);
            }
        });
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signView.clear();
            }
        });
    }
}
