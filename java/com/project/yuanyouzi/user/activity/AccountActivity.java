package com.project.laundryappui.user.activity;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.project.laundryappui.R;
import com.project.laundryappui.user.Util.GetUuid;
import com.project.laundryappui.user.Util.OKHttpUtil;
import com.project.laundryappui.user.Util.TextUtil;

public class AccountActivity extends AppCompatActivity {

    private final String baseUrl="http://192.168.218.1:8080";

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_account);
/*
*  返回,展示，修改，登录，注册，切换，退出
*  Wang
*  2023/3/28-2023/4/6
* */
        back();
        show();
        revise();
        login();
        register();
        handoff();
        quit();
    }

    private void back() {
        ImageButton iBtn = findViewById(R.id.button_back);
        iBtn.setOnClickListener(view -> finish());

        ImageButton iBtn1 = findViewById(R.id.button_back1);
        iBtn1.setOnClickListener(view -> finish());
    }

    //对账号的展示
    @SuppressLint("SetTextI18n")
    private void show() {
        TextView tBtn1=findViewById(R.id.A_T_11);
        RelativeLayout A1=findViewById(R.id.A_1);
        RelativeLayout A2=findViewById(R.id.A_2);

        String[] user=  TextUtil.readInfo();
        long id;
        int state;
        if (user != null) {
            id = Long.parseLong(user[0]);
            state = Integer.parseInt(user[1]);
            tBtn1.setText(String.valueOf(id));
            if (state == 0) {
                A1.setVisibility(View.VISIBLE);
                A2.setVisibility(View.GONE);
            } else {
                A1.setVisibility(View.GONE);
                A2.setVisibility(View.VISIBLE);
            }
        }
    }

    private void revise() {
        TextView tBtn2=findViewById(R.id.A_T_2);

        tBtn2.setOnClickListener(view->
                Toast.makeText(getApplicationContext(), "您还没有登录，无法修改密码！", Toast.LENGTH_SHORT).show());

        TextView tBtn22=findViewById(R.id.A_T_22);
        tBtn22.setOnClickListener(view->{
            Intent intent=new Intent(AccountActivity.this, ModificationActivity.class);
            startActivity(intent);
        });
    }

    private void login() {
        TextView tBtn3 = findViewById(R.id.A_T_3);
        tBtn3.setOnClickListener(view -> {
            Intent intent=new Intent(AccountActivity.this, SingInActivity.class);
            startActivity(intent);
        });
    }

    private void register() {
        TextView tBtn4=findViewById(R.id.A_T_4);
        tBtn4.setOnClickListener(view ->{
            Intent intent=new Intent(AccountActivity.this, RegisterActivity.class);
            startActivity(intent);
        });
    }

    private void handoff() {
        TextView tBtn5=findViewById(R.id.A_T_5);
        tBtn5.setOnClickListener(view->
                Toast.makeText(getApplicationContext(), "您还没有登录，无法切换账号！", Toast.LENGTH_SHORT).show());

        TextView tBtn3=findViewById(R.id.A_T_33);
        tBtn3.setOnClickListener(view->{
            String[] user=  TextUtil.readInfo();
            assert user != null;
            long Uid= Long.parseLong(user[0]);
            int state1=0;
            String sUser = (Uid+"_"+state1);

            Gson gson = new Gson();
            String json = gson.toJson(sUser);
            String[] args = new String[]{"user","quit"};
            String res = OKHttpUtil.postSyncRequest(baseUrl, json, args);

            Intent intent=new Intent(AccountActivity.this,SingInActivity.class);
            startActivity(intent);
            long id=0;
            int state=0;
            String uuid=GetUuid.getUUID();
            TextUtil.saveInfo(id,state,uuid);
            show();
        });
    }

    private void quit() {
        TextView tBtn6 = findViewById(R.id.A_T_6);

        tBtn6.setOnClickListener(view ->
                Toast.makeText(getApplicationContext(), "您还没有登录，无法退出账号！", Toast.LENGTH_SHORT).show());

        TextView tBtn44 = findViewById(R.id.A_T_44);
        tBtn44.setOnClickListener(view -> {
            String[] user=  TextUtil.readInfo();
            assert user != null;
            long id= Long.parseLong(user[0]);
            int state1=0;
            String sUser = (id+"_"+state1);

            Gson gson = new Gson();
            String json = gson.toJson(sUser);
            String[] args = new String[]{"user","quit"};
            String res = OKHttpUtil.postSyncRequest(baseUrl, json, args);

            long uid=0;
            int state=0;
            String uuid=GetUuid.getUUID();
            TextUtil.saveInfo(uid,state,uuid);
            show();
        });
    }


}