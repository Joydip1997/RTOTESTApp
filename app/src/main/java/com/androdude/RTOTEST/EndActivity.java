package com.androdude.RTOTEST;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EndActivity extends AppCompatActivity {

    private TextView Messege,correct,wrong,Cor,Wor;
    private Button playAgain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        Messege = (TextView)findViewById(R.id.messege);
        correct = (TextView)findViewById(R.id.correct_number);
        wrong = (TextView)findViewById(R.id.wrong_number);
        Cor = (TextView)findViewById(R.id.correct);
        Wor = (TextView)findViewById(R.id.wrong);
        playAgain = (Button)findViewById(R.id.Replay);

        String corect_answers = getIntent().getStringExtra("CorrectAnswers");
        String wrong_answers = getIntent().getStringExtra("WrongAnswers");





        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),menuitems.class));
                finish();

            }
        });



        if(Integer.parseInt(corect_answers) <= 5)
        {
            Messege.setText("Sorry Too Many Wrong Answers");
            correct.setText(corect_answers);
            wrong.setText(wrong_answers);
        }
        if(Integer.parseInt(corect_answers) >= 8 )
        {
            Messege.setText("Great!");
            correct.setText(corect_answers);
            wrong.setText(wrong_answers);
        }
        if(Integer.parseInt(corect_answers) >= 6 && Integer.parseInt(corect_answers) <= 7 )
        {
            Messege.setText("Good!");
            correct.setText(corect_answers);
            wrong.setText(wrong_answers);
        }




    }
}
