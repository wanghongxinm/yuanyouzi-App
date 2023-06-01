package com.project.laundryappui.user.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.project.laundryappui.MainActivity;
import com.project.laundryappui.R;
import com.project.laundryappui.user.Util.OKHttpUtil;
import com.project.laundryappui.user.Util.TextUtil;
import com.project.laundryappui.user.adapter.Person;

import java.util.Objects;

public class FeedbackActivity extends AppCompatActivity {

    private final String baseUrl="http://192.168.218.1:8080";

    private final String[] starArray = {"软件问题", "游戏问题", "其他问题"};

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_feedback);

        back();
        initSpinner();
    }

    private void back() {
        ImageButton iBtn = findViewById(R.id.fb_back);
        iBtn.setOnClickListener(view -> finish());
    }

    private void initSpinner() {
        ArrayAdapter<String> starAdapter = new ArrayAdapter<>(this, R.layout.item_select, starArray);
        starAdapter.setDropDownViewResource(R.layout.item_dropdown);
        Spinner sp = findViewById(R.id.spinner);
        sp.setPrompt("问题类别");
        sp.setAdapter(starAdapter);
        sp.setSelection(0);
        sp.setOnItemSelectedListener(new MySelectedListener());
    }

    class MySelectedListener implements AdapterView.OnItemSelectedListener {

        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            Button Btn=findViewById(R.id.Fb_b_1);
            EditText editText=findViewById(R.id.fb_T_4);
            TextView textView=findViewById(R.id.fb_T_1);

            String[] user=TextUtil.readInfo();
            long id= Long.parseLong(Objects.requireNonNull(user)[0]);
            String issue=starArray[i];
            textView.setText(String.valueOf(id));
            Btn.setOnClickListener(view1 -> {
                String description=String.valueOf(editText.getText());
                if(description.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "请输入您的问题描述！", Toast.LENGTH_SHORT).show();
                }else{
                    String rUser = (id + "_" + issue + "_" + description);
                    Gson gson = new Gson();
                    String json = gson.toJson(rUser);
                    String[] args = new String[]{"issue", "freeBack"};
                    String res = OKHttpUtil.postSyncRequest(baseUrl, json, args);

                    Person person = gson.fromJson(res, Person.class);
                    int code=person.getCode();
                    String msg= person.getMsg();
                    if(code == 200){
                        if(msg.equals("success-i0")){
                            Toast.makeText(getApplicationContext(), "反馈成功！", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(FeedbackActivity.this, MainActivity.class);
                            startActivity(intent);
                        }
                    }
                }
            });
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    }

}