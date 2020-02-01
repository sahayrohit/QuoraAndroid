package com.example.quoraandroid.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quoraandroid.R;
import com.example.quoraandroid.pojo.questionAndAnswer.responseHomePage.ContentItem;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

List<ContentItem> itemList;
PostClick postClick;

    public PostAdapter(List<ContentItem> itemList,PostClick postClick) {
        this.postClick = postClick;
        this.itemList=itemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.postlayout,parent,false);
        return new PostAdapter.ViewHolder(listItem);


    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {


        holder.mName.setText(itemList.get(position).getAskerProfileName());
        holder.mQuestion.setText(itemList.get(position).getQuestionValue());
        holder.mAnswer.setText(itemList.get(position).getApprovedAnswerId());


        holder.itemView.getRootView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        postClick.onClickSend();
                    }
                });

            }
        });
    }



    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView mName;
        TextView mQuestion;
        TextView mAnswer;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.mName = itemView.findViewById(R.id.post_user_name);
            this.mQuestion = itemView.findViewById(R.id.post_question_txt);
            this.mAnswer = itemView.findViewById(R.id.post_answer_txt);


        }
    }

    public interface PostClick{
       void onClickSend();
    }
}
