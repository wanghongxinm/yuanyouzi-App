package com.project.laundryappui.menu.home.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.project.laundryappui.R;
import com.project.laundryappui.user.Util.OKHttpUtil;
import com.project.laundryappui.user.adapter.Result;
import com.project.laundryappui.user.adapter.person1;

public class OtherGameFragment extends AppCompatActivity {

    private final String baseUrl="http://192.168.218.1:8080";

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_othergame);

        ImageButton buttonBack = findViewById(R.id.fb_back);
        buttonBack.setOnClickListener(view -> finish());

        show();
    }

    private void show() {
        RelativeLayout r1=findViewById(R.id.o_r_1);
        RelativeLayout r2=findViewById(R.id.o_r_2);

        TextView t1=findViewById(R.id.o_t_n_1);
        TextView t2=findViewById(R.id.o_t_n_2);
        TextView t3=findViewById(R.id.o_t_n_3);
        TextView t4=findViewById(R.id.o_t_n_4);

        TextView t5=findViewById(R.id.o_t_n1);
        TextView t6=findViewById(R.id.o_t_n2);
        TextView t7=findViewById(R.id.o_t_n3);
        TextView t8=findViewById(R.id.o_t_n4);

        String sUser = (1+"_"+2);

        Gson gson = new Gson();
        String json = gson.toJson(sUser);
        String[] args = new String[]{"other","others"};
        String res = OKHttpUtil.postSyncRequest(baseUrl, json, args);

        person1 person = gson.fromJson(res, person1.class);

        String result = person.getResult();
        String result1 = person.getResult1();

        String[] arr = {result, result1};

        Result result3 = gson.fromJson(arr[0], Result.class);
        Result result4 = gson.fromJson(arr[1], Result.class);

        t1.setText(result3.getName());
        t2.setText(result3.getTitle());
        t3.setText("点击前往官网查看更多");
        t4.setText( result3.getContent());

        t5.setText(result4.getName());
        t6.setText(result4.getTitle());
        t7.setText("点击前往官网查看更多");
        t8.setText( result4.getContent());

        r1.setOnClickListener(view -> {
            Uri uri = Uri.parse("http://192.168.218.1:8080/yuanyouzi/product/index.html");
            startActivity(Intent.createChooser(new Intent(Intent.ACTION_VIEW, uri), "Choose Browser"));
        });

        r2.setOnClickListener(view -> {
            Uri uri = Uri.parse("http://192.168.218.1:8080/yuanyouzi/product/index.html");
            startActivity(Intent.createChooser(new Intent(Intent.ACTION_VIEW, uri), "Choose Browser"));
        });
    }



}