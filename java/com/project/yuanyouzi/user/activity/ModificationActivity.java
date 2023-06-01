package com.project.laundryappui.user.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.project.laundryappui.R;
import com.project.laundryappui.user.Util.OKHttpUtil;
import com.project.laundryappui.user.Util.TextUtil;
import com.project.laundryappui.user.adapter.Person;

public class ModificationActivity extends AppCompatActivity {

    private final String baseUrl="http://192.168.218.1:8080";

    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_modification);

        back();
        modification();
    }

    private void back() {
            ImageButton iBtn=findViewById(R.id.R_back_1);
            iBtn.setOnClickListener(view -> onBackPressed());
    }

    private void modification() {
        Button rBtn=findViewById(R.id.R_login);
        EditText rPassword=findViewById(R.id.R_password);
        EditText rPassword1=findViewById(R.id.R_password1);
        EditText wen1=findViewById(R.id.r_wen1);
        EditText wen2=findViewById(R.id.r_wen2);

        rBtn.setOnClickListener(view-> {

            String password1 = rPassword.getText().toString();
            String password2 = rPassword1.getText().toString();
            String p1 = wen1.getText().toString();
            String p2 = wen2.getText().toString();

            if (password1.isEmpty()) {
                Toast.makeText(getApplicationContext(), "密码为空，请重试！", Toast.LENGTH_SHORT).show();
            } else {
                if (p1.length() < 5 && p2.length() < 5) {
                    if (password1.equals(password2)) {
                        String[] user=  TextUtil.readInfo();
                        assert user != null;
                        long id= Long.parseLong(user[0]);
                        String rUser = (id+"_"+password1 + "_" + p1 + "_" + p2);
                        Gson gson = new Gson();
                        String json = gson.toJson(rUser);
                        String[] args = new String[]{"user","modification"};
                        String res = OKHttpUtil.postSyncRequest(baseUrl, json, args);

                        Person person1 = gson.fromJson(res, Person.class);
                        Log.d("回传信息为：", String.valueOf(person1));
                        String msg=person1.getMsg();
                        System.out.print(msg);
                        if(msg.equals("success-m0")){
                            Toast.makeText(getApplicationContext(), "您的密码修改成功！", Toast.LENGTH_SHORT).show();
                            Intent intent =new Intent(ModificationActivity.this, AccountActivity.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(getApplicationContext(), "您的密保密码有误，请重试！", Toast.LENGTH_SHORT).show();
                        }
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "您的密保密码长度有误，请重试!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


}