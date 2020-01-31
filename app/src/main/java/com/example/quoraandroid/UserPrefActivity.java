package com.example.quoraandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.quoraandroid.pojo.registration.Interest;

import java.util.List;

public class UserPrefActivity extends AppCompatActivity {


    private Button register;
    List<Interest> interests;
    private CheckBox lifeStyle,cartoons,literature,cricket,coding,politics,movies,web,booze,food;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_pref);


        register=findViewById(R.id.finalRegister);
        lifeStyle=(CheckBox)findViewById(R.id.cb_lifestyle);
        cartoons=(CheckBox)findViewById(R.id.cb_cartoon);
        literature=(CheckBox)findViewById(R.id.cb_literature);
        cricket=(CheckBox)findViewById(R.id.cb_cricket);
        coding=(CheckBox)findViewById(R.id.cb_coding);
        politics=(CheckBox)findViewById(R.id.cb_Politics);
        movies=(CheckBox)findViewById(R.id.cb_movies);
        web=(CheckBox)findViewById(R.id.cb_web);
        booze=(CheckBox)findViewById(R.id.cb_booze);
        food=(CheckBox)findViewById(R.id.cb_food);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(lifeStyle.isChecked())
                {
                       interests.add(new Interest(String.valueOf(lifeStyle.getId()),lifeStyle.getText().toString()));

                }
                if(cartoons.isChecked())
                {
                    interests.add(new Interest(String.valueOf(cartoons.getId()),cartoons.getText().toString()));
                }
                if(literature.isChecked())
                {
                    interests.add( new Interest(String.valueOf(literature.getId()),literature.getText().toString()));
                }
                if(cricket.isChecked())
                {
                    interests.add(new Interest(String.valueOf(cricket.getId()),cricket.getText().toString()));
                }
                if(coding.isChecked())
                {
                    interests.add(new Interest(String.valueOf(coding.getId()),coding.getText().toString()));
                }
                if(politics.isChecked())
                {
                    interests.add(new Interest(String.valueOf(politics.getId()),politics.getText().toString()));
                }
                if(movies.isChecked())
                {
                    interests.add(new Interest(String.valueOf(movies.getId()),movies.getText().toString()));
                }
                if(web.isChecked())
                {

                    interests.add( new Interest(String.valueOf(web.getId()),web.getText().toString()));
                }
                if(booze.isChecked())
                {
                    interests.add(new Interest(String.valueOf(booze.getId()),booze.getText().toString()));
                }
                if(food.isChecked())
                {
                    interests.add(new Interest(String.valueOf(food.getId()),food.getText().toString()));
                }

            }
        });

    }
}
