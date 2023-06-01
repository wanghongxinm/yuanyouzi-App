package com.project.laundryappui.menu.home.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.laundryappui.R;
import com.project.laundryappui.menu.home.model.PropModel;

import java.util.List;

public class PropAdapter extends RecyclerView.Adapter<PropAdapter.ViewHolder>{

    List<PropModel> listProp;

    public PropAdapter(List<PropModel> listProp) {
        this.listProp = listProp;
    }

    @NonNull
    @Override
    public PropAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_prop, parent, false);
        return new PropAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PropAdapter.ViewHolder holder, int position) {
        PropModel list=listProp.get(position);

        holder.textName.setText(list.getName());
        holder.textContent.setText(list.getContent());

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

         TextView textName,textContent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textName       =itemView.findViewById(R.id.item_recommended_name);
            textContent    =itemView.findViewById(R.id.item_recommended_price);


        }
    }
}
