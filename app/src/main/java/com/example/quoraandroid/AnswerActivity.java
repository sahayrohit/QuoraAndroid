package com.example.quoraandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AnswerActivity extends AppCompatActivity {

    private Button mAnswerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        mAnswerButton = findViewById(R.id.answer_btn);
        mAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendToAnswerForQuestion();
            }
        });

    }

    private void sendToAnswerForQuestion() {

        Intent answer_for_question = new Intent(AnswerActivity.this,AnswerForQuestionActivity.class);
        startActivity(answer_for_question);

    }
}
