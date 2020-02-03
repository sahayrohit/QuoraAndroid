package com.example.quoraandroid.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quoraandroid.R;

import org.w3c.dom.Text;

public class ParticularQuestionAdapter extends RecyclerView.Adapter<ParticularQuestionAdapter.ViewHolder> {
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {



    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mQuestion,mUserName,mUserDetails,mAnswer;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mQuestion = itemView.findViewById(R.id.post_question_txt);
            mUserName = itemView.findViewById(R.id.post_user_name);
            mAnswer = itemView.findViewById(R.id.post_answer_txt);

        }
    }
}
