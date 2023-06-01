package com.project.laundryappui.menu.home.home_detail;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import com.project.laundryappui.R;

public class HomeDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hideStatusBar();
        setContentView(R.layout.activity_home_detail);

        ImageButton buttonBack = findViewById(R.id.button_back);
        buttonBack.setOnClickListener(view -> finish());
        show();
    }

    @SuppressLint("ObsoleteSdkInt")
    private void hideStatusBar() {
        try {
            if (Build.VERSION.SDK_INT >= 19) {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                getWindow().getDecorView().setSystemUiVisibility(3328);
            } else {
                requestWindowFeature(Window.FEATURE_NO_TITLE);
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void show() {
        TextView tName = findViewById(R.id.text_name);
        TextView tTime = findViewById(R.id.text_time);
        TextView tContent = findViewById(R.id.text_content);
        Intent intent=getIntent();
        String name=intent.getStringExtra("name");
        String state=intent.getStringExtra("state");
        String content=intent.getStringExtra("content");

        tName.setText(name);
        tTime.setText(state);
        tContent.setText(content);
    }


}