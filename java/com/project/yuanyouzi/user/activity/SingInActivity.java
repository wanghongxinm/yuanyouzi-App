package com.project.laundryappui.user.activity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.project.laundryappui.R;
import com.project.laundryappui.user.Util.GetUuid;
import com.project.laundryappui.user.Util.OKHttpUtil;
import com.project.laundryappui.user.Util.TextUtil;
import com.project.laundryappui.user.adapter.Person;

import java.util.List;

public class SingInActivity extends AppCompatActivity {

    private final String baseUrl="http://192.168.218.1:8080";

    @Override
    protected void onCreate(Bundle saveInstanceState){
     super.onCreate(saveInstanceState);
     setContentView(R.layout.activity_singin);

     back();
     login();
    }

    private void back() {
        ImageButton iBtn=findViewById(R.id.S_back);
        iBtn.setOnClickListener(view -> finish());
    }

    private void login() {
        Button tLogIn=findViewById(R.id.button_login);
        EditText tUser=findViewById(R.id.button_user);
        EditText tPassword=findViewById(R.id.button_password);

        tLogIn.setOnClickListener(view -> {
            String id = tUser.getText().toString();
            String password = tPassword.getText().toString();
            if(!id.isEmpty()&&!password.isEmpty()) {
                String sUser = (id + "_" + password);

                Gson gson = new Gson();
                String json = gson.toJson(sUser);
                String[] args = new String[]{"user", "login"};
                String res = OKHttpUtil.postSyncRequest(baseUrl, json, args);

                Person person1 = gson.fromJson(res, Person.class);
                int code = person1.getCode();
                String msg = String.valueOf(person1.getMsg());
                String uuid= GetUuid.getUUID();
                if (code == 200) {
                    switch (msg) {
                        case "success-s0":
                            Intent intent = new Intent(SingInActivity.this, AccountActivity.class);
                            startActivity(intent);
                            int uid= Integer.parseInt(id);
                            int state=1;
                            TextUtil.saveInfo(uid,state,uuid);
                            break;
                        case "success-s1":
                            Toast.makeText(getApplicationContext(), "密码错误！", Toast.LENGTH_SHORT).show();
                            break;
                        case "success-s2":
                            Toast.makeText(getApplicationContext(), "账号错误！", Toast.LENGTH_SHORT).show();
                            break;
                        case "success-s3":
                            Toast.makeText(getApplicationContext(), "请输入正确的账号和密码！", Toast.LENGTH_SHORT).show();
                            break;
                        case "success-s4":
                            Toast.makeText(getApplicationContext(), "您的账号已在其他地方登录，请稍后重试！", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            }
        });
    }

}