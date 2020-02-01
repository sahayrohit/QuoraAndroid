package com.example.quoraandroid.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quoraandroid.R;

import java.util.ArrayList;
import java.util.List;

public class UserProfileOptionsAdapter extends RecyclerView.Adapter<UserProfileOptionsAdapter.ViewHolder> {

    private ArrayList<String> userOption;
    public UserProfileOptionsAdapter(ArrayList<String> option){
        this.userOption = option;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.user_profile_oprtion_layout,parent,false);
        return new UserProfileOptionsAdapter.ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.mOption.setText(userOption.get(position));
    }

    @Override
    public int getItemCount() {
        return userOption.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mOption;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.mOption = itemView.findViewById(R.id.user_option_txt);
        }
    }
}
