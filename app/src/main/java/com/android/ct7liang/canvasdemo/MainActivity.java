package com.android.ct7liang.canvasdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.android.ct7liang.canvasdemo.activity.View01Activity;
import com.android.ct7liang.canvasdemo.activity.View02Activity;
import com.android.ct7liang.canvasdemo.activity.View03Activity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.draw_line).setOnClickListener(this);
        findViewById(R.id.draw_circle).setOnClickListener(this);
        findViewById(R.id.draw_rectangle).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.draw_line:
                startActivity(new Intent(this, View01Activity.class));
                break;
            case R.id.draw_circle:
                startActivity(new Intent(this, View02Activity.class));
                break;
            case R.id.draw_rectangle:
                startActivity(new Intent(this, View03Activity.class));
                break;
        }
    }
}
