package com.project.laundryappui.menu.home;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.project.laundryappui.R;
import com.project.laundryappui.menu.home.adapter.HomeAdapter;
import com.project.laundryappui.menu.home.model.Events;
import com.project.laundryappui.menu.home.model.HomeModel;
import com.project.laundryappui.user.Util.OKHttpUtil;
import com.project.laundryappui.user.adapter.Result;
import com.project.laundryappui.user.adapter.person1;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private Context mContext;
    private RecyclerView recyclerView;
    private List<HomeModel> homeModelList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setAdapterType(view);
        setAdapter();
    }

    private void initData() {
        homeModelList = new ArrayList<>();
        String rUser = (1 + "_" + 2 + "_" + 3);
        Gson gson = new Gson();
        String json = gson.toJson(rUser);
        String[] args = new String[]{"events", "event"};
        String baseUrl = "http://192.168.218.1:8080";
        String res = OKHttpUtil.postSyncRequest(baseUrl, json, args);

        person1 person = gson.fromJson(res, person1.class);
        int code = person.getCode();
        if(code==200) {
            String result = person.getResult();
            String result1 = person.getResult1();
            String result2 = person.getResult2();

            String[] arr = {result, result1, result2};

            Result result3 = gson.fromJson(arr[0], Result.class);
            Result result4 = gson.fromJson(arr[1], Result.class);
            Result result5 = gson.fromJson(arr[2], Result.class);

            Events events = new Events();
            Events events1 = new Events();
            Events events2 = new Events();

            events.setName(result3.getName());
            events.setTitle(result3.getTitle());
            events.setContent(result3.getContent());
            events.setState(result3.getState());

            events1.setName(result4.getName());
            events1.setTitle(result4.getTitle());
            events1.setContent(result4.getContent());
            events1.setState(result4.getState());

            events2.setName(result5.getName());
            events2.setTitle(result5.getTitle());
            events2.setContent(result5.getContent());
            events2.setState(result5.getState());

            homeModelList.add(new HomeModel(events.getContent(), events.getTitle(), events.getState(), events.getName()));
            homeModelList.add(new HomeModel(events1.getContent(), events1.getTitle(), events1.getState(), events1.getName()));
            homeModelList.add(new HomeModel(events2.getContent(), events2.getTitle(), events2.getState(), events2.getName()));

        }else {
            Events events = new Events();

            homeModelList.add(new HomeModel(events.getContent(), events.getTitle(), events.getState(), events.getName()));
            homeModelList.add(new HomeModel(events.getContent(), events.getTitle(), events.getState(), events.getName()));
            homeModelList.add(new HomeModel(events.getContent(), events.getTitle(), events.getState(), events.getName()));
        }
    }

    private void setAdapterType(View view) {
        recyclerView  = view.findViewById(R.id.recyclerview_recommended);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setNestedScrollingEnabled(true);
    }

    private void setAdapter() {
        initData();
        HomeAdapter homeAdapter = new HomeAdapter(homeModelList);
        recyclerView.setAdapter(homeAdapter);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }


}