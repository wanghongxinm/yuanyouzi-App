package com.project.laundryappui.user.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.project.laundryappui.R;
import com.project.laundryappui.user.Util.OKHttpUtil;
import com.project.laundryappui.user.Util.TextUtil;

public class MessageSetActivity extends AppCompatActivity {

    private final String baseUrl="http://192.168.218.1:8080";

    public static boolean status1=false;
    public static boolean status2=true;
    public static boolean status3=true;
    public static boolean status4=true;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_messageset);
/*
* 返回，关闭全部消息通知，关闭我发布的消息通知，关闭回复我的消息通知，关闭系统的消息通知,获取id
* wang
* 2023/4/6
* */
        back();
        close1();
        close2();
        close3();
        close4();
        getId();
    }

    private long getId() {
        String[] user=  TextUtil.readInfo();
        assert user != null;
        return Long.parseLong(user[0]);
    }

    private void back() {
        ImageButton iBtn=findViewById(R.id.ms_back);
        iBtn.setOnClickListener(view->  finish());
    }

    private void close1() {
        @SuppressLint("UseSwitchCompatOrMaterialCode")
        Switch s1=findViewById(R.id.ms1_status);
        @SuppressLint("UseSwitchCompatOrMaterialCode")
        Switch s2=findViewById(R.id.ms2_status);
        @SuppressLint("UseSwitchCompatOrMaterialCode")
        Switch s3=findViewById(R.id.ms3_status);
        @SuppressLint("UseSwitchCompatOrMaterialCode")
        Switch s4=findViewById(R.id.ms4_status);
        s1.setOnClickListener(view ->{
            status1=!status1;
              if(status1){
                  s2.setChecked(false);
                  s3.setChecked(false);
                  s4.setChecked(false);
                  Toast.makeText(getApplicationContext(), "关闭了全部的消息通知！",Toast.LENGTH_SHORT).show();
                  long id=getId();
                  int state1=1;
                  String rUser = (id+"_"+state1);
                  Gson gson = new Gson();
                  String json = gson.toJson(rUser);
                  String[] args = new String[]{"user","state1"};
                  String res = OKHttpUtil.postSyncRequest(baseUrl, json, args);
              }else {
                  s1.setChecked(true);
                  s2.setChecked(true);
                  s3.setChecked(true);
                  s4.setChecked(true);
                  Toast.makeText(getApplicationContext(), "开启了全部的消息通知！", Toast.LENGTH_SHORT).show();
                  long id=getId();
                  int state1=0;
                  String rUser = (id+"_"+state1);
                  Gson gson = new Gson();
                  String json = gson.toJson(rUser);
                  String[] args = new String[]{"user","state1"};
                  String res = OKHttpUtil.postSyncRequest(baseUrl, json, args);
              }
        }
        );
    }

    private void close2() {
        @SuppressLint("UseSwitchCompatOrMaterialCode")
        Switch s2=findViewById(R.id.ms2_status);
        s2.setOnClickListener(view ->{
            status2=!status2;
            if(status2){
                s2.setChecked(false);
                Toast.makeText(getApplicationContext(), "关闭了我发布的消息通知！",Toast.LENGTH_SHORT).show();
                long id=getId();
                int state1=1;
                String rUser = (id+"_"+state1);
                Gson gson = new Gson();
                String json = gson.toJson(rUser);
                String[] args = new String[]{"user","state2"};
                String res = OKHttpUtil.postSyncRequest(baseUrl, json, args);
            }else {
                s2.setChecked(true);
                Toast.makeText(getApplicationContext(), "开启了我发布的消息通知！", Toast.LENGTH_SHORT).show();
                long id=getId();
                int state1=0;
                String rUser = (id+"_"+state1);
                Gson gson = new Gson();
                String json = gson.toJson(rUser);
                String[] args = new String[]{"user","state2"};
                String res = OKHttpUtil.postSyncRequest(baseUrl, json, args);
            }
        });
    }

    private void close3() {
        @SuppressLint("UseSwitchCompatOrMaterialCode")
        Switch s3=findViewById(R.id.ms3_status);
        s3.setOnClickListener(view ->{
            status3=!status3;
            if(status3){
                s3.setChecked(false);
                Toast.makeText(getApplicationContext(), "关闭了回复我的消息通知！", Toast.LENGTH_SHORT).show();
                long id=getId();
                int state1=1;
                String rUser = (id+"_"+state1);
                Gson gson = new Gson();
                String json = gson.toJson(rUser);
                String[] args = new String[]{"user","state3"};
                String res = OKHttpUtil.postSyncRequest(baseUrl, json, args);
            }else {
                s3.setChecked(true);
                Toast.makeText(getApplicationContext(), "开启了回复的消息通知！", Toast.LENGTH_SHORT).show();
                long id=getId();
                int state1=0;
                String rUser = (id+"_"+state1);
                Gson gson = new Gson();
                String json = gson.toJson(rUser);
                String[] args = new String[]{"user","state3"};
                String res = OKHttpUtil.postSyncRequest(baseUrl, json, args);
            }
        });
    }

    private void close4() {
        @SuppressLint("UseSwitchCompatOrMaterialCode")
        Switch s4=findViewById(R.id.ms4_status);
        s4.setOnClickListener(view ->{
            status4=!status4;
                if (status4) {
                    s4.setChecked(false);
                    Toast.makeText(getApplicationContext(), "关闭了系统的消息通知！", Toast.LENGTH_SHORT).show();
                    long id=getId();
                    int state1=1;
                    String rUser = (id+"_"+state1);
                    Gson gson = new Gson();
                    String json = gson.toJson(rUser);
                    String[] args = new String[]{"user","state4"};
                    String res = OKHttpUtil.postSyncRequest(baseUrl, json, args);
                } else {
                    s4.setChecked(true);
                    Toast.makeText(getApplicationContext(), "开启了系统的消息通知！", Toast.LENGTH_SHORT).show();
                    long id=getId();
                    int state1=0;
                    String rUser = (id+"_"+state1);
                    Gson gson = new Gson();
                    String json = gson.toJson(rUser);
                    String[] args = new String[]{"user","state4"};
                    String res = OKHttpUtil.postSyncRequest(baseUrl, json, args);
                }
        });
    }

}