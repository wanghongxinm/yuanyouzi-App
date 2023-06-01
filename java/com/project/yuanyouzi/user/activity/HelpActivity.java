package com.project.laundryappui.user.activity;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.project.laundryappui.R;

public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_help);

        back();
        update();
        introduce();
        agreement();
        privacy();
    }

    private void back() {
        ImageButton iBtn=findViewById(R.id.ap_back);
        iBtn.setOnClickListener(view -> finish());
    }

    private void update() {
        float version= (float) 1.1;
        TextView tBtn1=findViewById(R.id.Ap_T_1);
        TextView tBtn2=findViewById(R.id.Ap_T_2);
        TextView tBtn22=findViewById(R.id.Ap_T_22);
        tBtn1.setOnClickListener(view ->{
           if(version>1.3){
               tBtn22.setVisibility(GONE);
               tBtn2.setVisibility(VISIBLE);
               Toast.makeText(getApplicationContext(), "请前往官网下载最新版！", Toast.LENGTH_SHORT).show();
           }else{
               tBtn22.setVisibility(VISIBLE);
               tBtn2.setVisibility(GONE);
           }
        });
    }

    private void introduce() {
        TextView tBtn3=findViewById(R.id.Ap_T_3);
        tBtn3.setOnClickListener(view ->{
            Uri uri = Uri.parse("http://192.168.218.1:8080/yuanyouzi/product/index.html");
            startActivity(Intent.createChooser(new Intent(Intent.ACTION_VIEW, uri), "YuanYouZi"));
        });
    }

    private void agreement() {
        TextView tBtn4=findViewById(R.id.Ap_T_4);
        tBtn4.setOnClickListener(view ->{
            Toast.makeText(getApplicationContext(), "正在为您跳转服务协议界面！", Toast.LENGTH_SHORT).show();
            //跳转到网页
        });
    }

    private void privacy() {
        TextView tBtn5=findViewById(R.id.Ap_T_5);
        tBtn5.setOnClickListener(view ->{
            Toast.makeText(getApplicationContext(), "正在为您跳转隐私政策界面！", Toast.LENGTH_SHORT).show();
            //跳转到网页
        });
    }
}