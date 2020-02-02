package com.example.quoraandroid.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quoraandroid.R;
import com.example.quoraandroid.pojo.search.ContentItem;
import com.example.quoraandroid.pojo.search.SearchPaginatedResponse;

import java.util.ArrayList;
import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {
    List<ContentItem> itemList;


    public SearchAdapter(List<ContentItem> content) {
        this.itemList = content;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.search_list,parent,false);
        return new SearchAdapter.ViewHolder(listItem);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.mQuestions.setText(itemList.get(position).getQuestionValue().toString());
        holder.mName.setText(itemList.get(position).getProfileValue());

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mQuestions;
        private TextView mName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.mQuestions = itemView.findViewById(R.id.search_txt);
            this.mName = itemView.findViewById(R.id.search_name_txt);


        }
    }
}
