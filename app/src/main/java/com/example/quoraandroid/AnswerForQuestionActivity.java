package com.example.quoraandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class AnswerForQuestionActivity extends AppCompatActivity {

    private Button mAnswerButton;
    private TextInputEditText mAnswerText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_for_question);


        mAnswerText = findViewById(R.id.add_answer_bar);

        mAnswerButton = findViewById(R.id.add_answer_btn);


        mAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String answer = mAnswerText.getText().toString(); //answer from edit text
                //API Response








                //sendToAnswerAgain
                sendToAnswer();
            }
        });


    }

    private void sendToAnswer() {

        Intent answer_intent = new Intent(AnswerForQuestionActivity.this,AnswerActivity.class);
        startActivity(answer_intent);
        finish();


    }
}
