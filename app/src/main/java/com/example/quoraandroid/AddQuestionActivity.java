package com.example.quoraandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.quoraandroid.pojo.questionAndAnswer.QuestionsDTO;
import com.google.android.gms.common.api.Response;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

import static com.example.quoraandroid.MainActivity.myPreference;


public class AddQuestionActivity extends AppCompatActivity {

    private TextInputEditText mAddquestionText;
    private Button mAddBtn;
    private Spinner mCategorySpinner;
    SharedPreferences sharedPreferences;
    public static final String myPreference = "login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_question);
      //  final SharedPreferences sharedPreferences=getSharedPreferences("login",MODE_PRIVATE);



        mAddquestionText = findViewById(R.id.add_question_bar);
        mAddBtn = findViewById(R.id.add_question_btn);
        mCategorySpinner = findViewById(R.id.spinner_cat);



        //ProgressBars
        final ProgressDialog progressBar = new ProgressDialog(this);
        progressBar.setCancelable(true);
        progressBar.setMessage("Please Wait...");
        progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressBar.setProgress(0);
        progressBar.setMax(100);
        // progressBar.show();
        //get  All Categories
        progressBar.show();
        App.getRetrofitCategories().create(RetroAPI.class).getAllCategories().enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, retrofit2.Response<List<String>> response) {
                progressBar.dismiss();
                List<String> list=response.body();
                Toast.makeText(AddQuestionActivity.this,list.get(0).toString(), Toast.LENGTH_LONG).show();

                ArrayAdapter<String> adp1 = new ArrayAdapter<String>(AddQuestionActivity.this, android.R.layout.simple_spinner_dropdown_item, list);
                mCategorySpinner.setAdapter(adp1);

            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {
                progressBar.dismiss();

                Log.d("Fail","failure");
            }
        });





        mAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences = getSharedPreferences(myPreference, Context.MODE_PRIVATE);
                String account = sharedPreferences.getString("accessToken", null);

                String question = mAddquestionText.getText().toString();

                String  selectedCat = mCategorySpinner.getSelectedItem().toString();

                Toast.makeText(AddQuestionActivity.this, "cat="+selectedCat, Toast.LENGTH_SHORT).show();


                QuestionsDTO questionsDTO=new QuestionsDTO();
                questionsDTO.setCategoryId(selectedCat);       //from spinner
                questionsDTO.setQuestionValue(question);        //from que text
                questionsDTO.setCategoryName(selectedCat);  //from spinner

               // String id=sharedPreferences.getString("accessToken","");
                progressBar.show();
                App.getRetrofit().create(RetroAPI.class).addQuestion(questionsDTO,account).enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, retrofit2.Response<String> response) {
                        Toast.makeText(AddQuestionActivity.this, "Sucessfully added", Toast.LENGTH_SHORT).show();
                        progressBar.dismiss();
                        sendToMain();
                    }

                    @Override
            public void onFailure(Call<String> call, Throwable t) {
                        Toast.makeText(AddQuestionActivity.this, "failed", Toast.LENGTH_SHORT).show();
                        progressBar.dismiss();

            }
        });






      //  questionsDTO.setAskerProfileId(account);   //accesstoken

//        questionsDTO.setAskerProfileName("Raghav");
//        questionsDTO.setProfileWhereAskedName("Arnav");
//        questionsDTO.setProfileWhereAskedId("2");
//        questionsDTO.setProfileWhereAskedType("public");



//
//
//
//        String id=sharedPreferences.getString("accessToken","");
//
//        App.getRetrofit().create(RetroAPI.class).addQuestion(questionsDTO,id).enqueue(new Callback<String>() {
//            @Override
//            public void onResponse(Call<String> call, Response<String> response) {
//
//
//
//            }
//
//            @Override
//            public void onFailure(Call<String> call, Throwable t) {
//
//            }
//        });










            }
        });



    }

    private void sendToMain() {
        Intent main_intent = new Intent(AddQuestionActivity.this,MainActivity.class);
        startActivity(main_intent);
        finish();
    }
}
