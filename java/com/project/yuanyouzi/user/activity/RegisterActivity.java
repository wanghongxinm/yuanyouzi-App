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
import com.project.laundryappui.user.adapter.Person;


public class RegisterActivity extends AppCompatActivity {

    //请求的后端地址
    private final String baseUrl="http://192.168.218.1:8080";

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_register);

        back();
        register();
    }

    private void back() {
        ImageButton iBtn=findViewById(R.id.R_back);
        iBtn.setOnClickListener(view ->finish());
    }

    private void register() {
        Button rBtn=findViewById(R.id.R_login);
        EditText rPassword=findViewById(R.id.R_password);
        EditText rPassword1=findViewById(R.id.R_password1);
        EditText wen1=findViewById(R.id.r_wen1);
        EditText wen2=findViewById(R.id.r_wen2);

        rBtn.setOnClickListener(view->{

            String password1=rPassword.getText().toString();
            String password2=rPassword1.getText().toString();
            String p1=wen1.getText().toString();
            String p2= wen2.getText().toString();

            if(password1.isEmpty()){
                Toast.makeText(getApplicationContext(), "密码为空，请重试！", Toast.LENGTH_SHORT).show();
            }else {
                if (p1.length() < 5 && p2.length() < 5) {
                    if (password1.equals(password2)) {

                        int state = 0;
                        int state1 = 0;
                        int state2 = 0;
                        int state3 = 0;
                        int state4 = 0;

                        String uuid = GetUuid.getUUID();
                        System.out.println(uuid);
                        String rUser = (password1 + "_" + p1 + "_" + p2 + "_" + state
                                + "_" + state1 + "_" + state2 + "_" + state3 + "_" + state4 + "_" + uuid);
                        Gson gson = new Gson();
                        String json = gson.toJson(rUser);
                        String[] args = new String[]{"user", "insert"};
                        String res = OKHttpUtil.postSyncRequest(baseUrl, json, args);

                        Person person = gson.fromJson(res, Person.class);
                        long id = Integer.parseInt(person.getResult());
                        Toast.makeText(getApplicationContext(), "注册成功！您的账号为：" + id, Toast.LENGTH_LONG).show();
                        Intent Intent=new Intent(RegisterActivity.this, SingInActivity.class);
                        startActivity(Intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "密码错误，请重试！", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "密保问题错误！", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}