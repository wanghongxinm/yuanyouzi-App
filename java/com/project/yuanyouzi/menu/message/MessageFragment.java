package com.project.laundryappui.menu.message;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.project.laundryappui.R;
import com.project.laundryappui.user.activity.AccountActivity;
import com.project.laundryappui.user.activity.FeedbackActivity;
import com.project.laundryappui.user.activity.HelpActivity;
import com.project.laundryappui.user.activity.MessageSetActivity;


public class MessageFragment extends  Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_message, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        AccountSigIn(view);
        Set(view);
        Help(view);
        Feedback(view);
        AboutMe(view);
    }

    private void AccountSigIn(View view) {
        LinearLayout m1 = view.findViewById(R.id.M_1);
        m1.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), AccountActivity.class);
            startActivity(intent);
        });
    }

    private void Set(View view){
        LinearLayout m2 = view.findViewById(R.id.M_2);
        m2.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), MessageSetActivity.class);
            startActivity(intent);
        });
    }

    private void Help(View view) {
        LinearLayout m3 = view.findViewById(R.id.M_3);
        m3.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), HelpActivity.class);
            startActivity(intent);
        });
    }

    private void Feedback(View view) {
        LinearLayout m4 = view.findViewById(R.id.M_4);
        m4.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), FeedbackActivity.class);
            startActivity(intent);
        });
    }

    private void AboutMe(View view) {
        LinearLayout m5 = view.findViewById(R.id.M_5);
        m5.setOnClickListener(v -> {
            Uri uri = Uri.parse("http://192.168.218.1:8080/yuanyouzi/about/index.html");
            startActivity(Intent.createChooser(new Intent(Intent.ACTION_VIEW, uri), "Choose Browser"));
        });
    }
}