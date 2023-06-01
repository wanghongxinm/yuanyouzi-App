package com.project.laundryappui.menu.notification;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.project.laundryappui.R;
import com.project.laundryappui.menu.message.PublishMessageActivity;
import com.project.laundryappui.menu.message.ReplyMessageActivity;
import com.project.laundryappui.menu.message.OfficialMessageActivity;
import com.project.laundryappui.user.Util.TextUtil;

public class NotificationFragment extends Fragment {

    @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
      return inflater.inflate(R.layout.fragment_notification, container, false);
  }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        message1(view);
        message2(view);
        message3(view);
        message4(view);
        show(view);
    }

    private void show(View view) {
        TextView tBtn= view.findViewById(R.id.message_user);
        String[] user=  TextUtil.readInfo();
        assert user != null;
        long id = Long.parseLong(user[0]);
            tBtn.setText(String.valueOf(id));
    }

    private void message1(View view) {
        RelativeLayout nr1 = view.findViewById(R.id.N_R_1);
        nr1.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), PublishMessageActivity.class);
            startActivity(intent);
        });
    }

    private void message2(View view) {
        RelativeLayout nr2 = view.findViewById(R.id.N_R_2);
        nr2.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), ReplyMessageActivity.class);
            startActivity(intent);
        });
    }

    private void message3(View view) {
        RelativeLayout nr3 = view.findViewById(R.id.N_R_3);
        nr3.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), OfficialMessageActivity.class);
            startActivity(intent);
        });
    }

    private void message4(View view) {
        RelativeLayout nr4 = view.findViewById(R.id.N_R_4);
        nr4.setOnClickListener(v -> {
            Uri uri = Uri.parse("https://baidu.com");
            startActivity(Intent.createChooser(new Intent(Intent.ACTION_VIEW, uri), "Choose Browser"));
        });
    }


}