package com.androdude.RTOTEST;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
   private Button Answer1,Answer2,Answer3,Next;
   private TextView Question,cAnswers,wAnswers,timerview;
   private ImageView image,img1;
   private Boolean flag;
   String flag0="",flag1="",flag2="";
   String a1="";
   String a2="";
   String a3="";
   String isEnd="";
   Boolean a=false,b=false,c=false;
   List<Questionitem> questionitem;
   ArrayList<Button> buttonList = new ArrayList<Button>();
    final Handler handler = new Handler();

   int currentQuestion=0,correct=0,wrong=0;

    @Override
    public void onBackPressed() {
// super.onBackPressed();
        onBack();
// Not calling **super**, disables back button in current screen.
    }

    CountDownTimer cTinmer =  new CountDownTimer(30000, 1000) {

        public void onTick(long millisUntilFinished) {
            timerview.setText("" + millisUntilFinished / 1000);
            //here you can have your logic to set text to edittext

        }

        public void onFinish() {
            wrong++;
            wAnswers.setText(String.valueOf(wrong));

            String Answer = questionitem.get(currentQuestion).getCorrect();


            if(Answer.equals(Answer1.getText().toString()))
            {
                Answer2.setBackgroundColor(Color.RED);
                Answer1.setBackgroundColor(Color.GREEN);
                Answer3.setBackgroundColor(Color.RED);
            }
            if(Answer.equals(Answer2.getText().toString()))
            {
                Answer1.setBackgroundColor(Color.RED);
                Answer2.setBackgroundColor(Color.GREEN);
                Answer3.setBackgroundColor(Color.RED);
            }
            if(Answer.equals(Answer3.getText().toString()))
            {
               Answer1.setBackgroundColor(Color.RED);
                Answer3.setBackgroundColor(Color.GREEN);
                Answer2.setBackgroundColor(Color.RED);
            }
            cTinmer.cancel();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if(currentQuestion<questionitem.size()-41)
                    {
                        Answer1.setBackgroundColor(getResources().getColor(R.color.bttn));
                        Answer2.setBackgroundColor(getResources().getColor(R.color.bttn));
                        Answer3.setBackgroundColor(getResources().getColor(R.color.bttn));
                        int num = currentQuestion+1;
                        Toast.makeText(MainActivity.this, "aa " + num, Toast.LENGTH_SHORT).show();
                        currentQuestion++;
                        setQuestiononScreen(currentQuestion);
                        cTinmer.start();
                    }
                    else
                        {
                            cTinmer.cancel();
                            finish();
                            currentQuestion=0;
                            Intent endVales = new Intent(getApplicationContext(),EndActivity.class)
                                    .putExtra("CorrectAnswers",String.valueOf(correct))
                                    .putExtra("WrongAnswers",String.valueOf(wrong));
                            startActivity(endVales);

                        }


                }
            },1000);




        }
    }.start();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentQuestion=0;

        setView();
        //get all questions
        loadAllQuestions();
        //Shuffeling Questions
        Collections.shuffle(questionitem);
        //Load first question
        setQuestiononScreen(currentQuestion);
        cTinmer.cancel();
        cTinmer.start();


        cAnswers.setText(String.valueOf(correct));
        wAnswers.setText(String.valueOf(wrong));

        Answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a=true;
                //checking the answers if the are correct or not
                Answer2.setBackgroundColor(getResources().getColor(R.color.bttn));
                Answer3.setBackgroundColor(getResources().getColor(R.color.bttn));
                Answer1.setBackgroundColor(Color.GREEN);
                if(questionitem.get(currentQuestion).getAnswer1().equals(questionitem.get(currentQuestion).getCorrect()))
                {
                    flag = true;
                    flag0="3";
                    Answer1.setBackgroundColor(Color.GREEN);
                }
                else
                {
                    flag=false;
                    flag0="4";
                    String ans = questionitem.get(currentQuestion).getCorrect();
                    String right1 = questionitem.get(currentQuestion).getAnswer2();
                    String right2 = questionitem.get(currentQuestion).getAnswer3();

                   if(ans.equals(right1))
                   {
                       a1="1";

                   }
                   else
                   {

                       a1="2";

                   }
                }


            }
        });


        Answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b=true;
                //checking the answers if the are correct or not
                Answer1.setBackgroundColor(getResources().getColor(R.color.bttn));
                Answer3.setBackgroundColor(getResources().getColor(R.color.bttn));
                Answer2.setBackgroundColor(Color.GREEN);
                if(questionitem.get(currentQuestion).getAnswer2().equals(questionitem.get(currentQuestion).getCorrect()))
                {
                    flag = true;
                    flag1="3";
                    Answer2.setBackgroundColor(Color.GREEN);
                }
                else
                {

                    flag=false;
                    flag1="4";
                    String ans1 = questionitem.get(currentQuestion).getCorrect();
                    String right3 = questionitem.get(currentQuestion).getAnswer1();
                    String right4 = questionitem.get(currentQuestion).getAnswer3();

                  if(ans1.equals(right3))
                    {
                        a2="1";


                    }
                    else
                    {
                        a2="2";
                    }
                }


            }
        });

        Answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c=true;
                //checking the answers if the are correct or not
                Answer1.setBackgroundColor(getResources().getColor(R.color.bttn));
                Answer2.setBackgroundColor(getResources().getColor(R.color.bttn));
                Answer3.setBackgroundColor(Color.GREEN);

                if(questionitem.get(currentQuestion).getAnswer3().equals(questionitem.get(currentQuestion).getCorrect()))
                {
                    flag = true;
                    flag2="3";
                    Answer3.setBackgroundColor(Color.GREEN);
                }
                else
                {
                    flag=false;
                    flag2="4";
                    String ans2 = questionitem.get(currentQuestion).getCorrect();
                    String right4 = questionitem.get(currentQuestion).getAnswer1();
                    String right5 = questionitem.get(currentQuestion).getAnswer2();

                    if(ans2.equals(right4))
                    {
                        a3="1";

                    }
                    else
                    {

                        a3="2";

                    }
                }


            }
        });

        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(a==true || b==true || c==true)
                {


                    if(flag0.equals("4")) {
                        if (a1.equals("1")) {
                            Answer1.setBackgroundColor(Color.RED);
                            Answer2.setBackgroundColor(Color.GREEN);
                            Answer3.setBackgroundColor(Color.RED);
                            a1 = "-1";
                            flag0="-1";
                        } else {
                            Answer1.setBackgroundColor(Color.RED);
                            Answer3.setBackgroundColor(Color.GREEN);
                            Answer2.setBackgroundColor(Color.RED);
                            a1 = "-1";
                            flag0="-1";
                        }
                    }

                    if(flag1.equals("4")) {
                        if(a2.equals("1"))
                        {
                            Answer2.setBackgroundColor(Color.RED);
                            Answer1.setBackgroundColor(Color.GREEN);
                            Answer3.setBackgroundColor(Color.RED);
                            a2 = "-1";
                            flag1="-1";
                        }
                        else
                        {
                            Answer1.setBackgroundColor(Color.RED);
                            Answer3.setBackgroundColor(Color.GREEN);
                            Answer2.setBackgroundColor(Color.RED);
                            a2 = "-1";
                            flag1="-1";
                        }

                    }



                    if(flag2.equals("4"))
                    {


                        if(a3.equals("1"))
                        {
                            Answer2.setBackgroundColor(Color.RED);
                            Answer1.setBackgroundColor(Color.GREEN);
                            Answer3.setBackgroundColor(Color.RED);
                            a3 = "-1";
                            flag2="-1";
                        }
                        else
                        {
                            Answer1.setBackgroundColor(Color.RED);
                            Answer2.setBackgroundColor(Color.GREEN);
                            Answer3.setBackgroundColor(Color.RED);
                            a1 = "-1";
                            flag2="-1";
                        }
                    }
                    if(flag)
                    {
                        correct++;
                        cAnswers.setText(String.valueOf(correct));
                        wAnswers.setText(String.valueOf(wrong));
                    }
                    else
                    {
                        wrong++;
                        cAnswers.setText(String.valueOf(correct));
                        wAnswers.setText(String.valueOf(wrong));
                    }


                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if(currentQuestion<questionitem.size()-41)
                            {
                                Answer1.setBackgroundColor(getResources().getColor(R.color.bttn));
                                Answer2.setBackgroundColor(getResources().getColor(R.color.bttn));
                                Answer3.setBackgroundColor(getResources().getColor(R.color.bttn));
                                cTinmer.cancel();
                                cTinmer.start();
                                currentQuestion++;
                                setQuestiononScreen(currentQuestion);
                            }
                            else
                            {   currentQuestion=0;
                                cTinmer.cancel();
                                finish();
                                Intent endVales = new Intent(getApplicationContext(),EndActivity.class)
                                        .putExtra("CorrectAnswers",String.valueOf(correct))
                                        .putExtra("WrongAnswers",String.valueOf(wrong));
                                startActivity(endVales);

                            }
                        }
                    }, 1000);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Answer The Question", Toast.LENGTH_SHORT).show();
                }


                a =false;
                b=false;
                c=false;

            }
        });



      /*  Answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //checking the answers if the are correct or not
                if(questionitem.get(currentQuestion).getAnswer4().equals(questionitem.get(currentQuestion).getCorrect()))
                {
                    //Answer is correct
                    Toast.makeText(MainActivity.this, "Correct", Toast.LENGTH_SHORT).show();
                    correct++;
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Wrong" + "Correct Amswer Is " + questionitem.get(currentQuestion).getCorrect(), Toast.LENGTH_SHORT).show();
                    wrong++;

                }

                if(currentQuestion<questionitem.size()-1)
                {
                    currentQuestion++;
                    setQuestiononScreen(currentQuestion);
                }
                else
                {

                    Toast.makeText(MainActivity.this, "End", Toast.LENGTH_SHORT).show();
                    Intent endVales = new Intent(getApplicationContext(),EndActivity.class)
                            .putExtra("CorrectAnswers",String.valueOf(correct))
                            .putExtra("WrongAnswers",String.valueOf(wrong));
                    startActivity(endVales);
                }
            }
        });*/



    }



    public void setView()
    {
        Question = (TextView)findViewById(R.id.question);
        Answer1 = (Button)findViewById(R.id.answer1);
        Answer2 = (Button)findViewById(R.id.answer2);
        Answer3 = (Button)findViewById(R.id.answer3);
        Next = (Button)findViewById(R.id.next);
        image = (ImageView)findViewById(R.id.img);
        img1 = (ImageView)findViewById(R.id.img1);
        cAnswers = (TextView)findViewById(R.id.number_corect_answers);
        wAnswers = (TextView)findViewById(R.id.number_wrong_answers);
        timerview = (TextView)findViewById(R.id.timerView);
    }


//Loading JSON From Assets
private  String loadJSONFromAssets(String file)
{
    String json = "";
    try
    {
        InputStream is = getAssets().open(file);
        int size = is.available();
        byte buffer[] = new byte[size];
        is.read(buffer);
        is.close();
        json = new String(buffer,"UTF-8");
    } catch (IOException e) {
        e.printStackTrace();
    }
    return json;
}

//make a list of all questions
    private void loadAllQuestions()
    {
        questionitem = new ArrayList<>();

        String JsonStr = loadJSONFromAssets("questions.JSON");

        try
        {
            JSONObject obj = new JSONObject(JsonStr);
            JSONArray questions = obj.getJSONArray("questions");
            for(int i=0;i<questions.length();i++)
            {
                JSONObject question = questions.getJSONObject(i);

                String imgurlSTR = question.getString("url");
                String questionSTR = question.getString("Question");
                String answer1STR = question.getString("answer1");
                String answer2STR = question.getString("answer2");
                String answer3STR = question.getString("answer3");
                String correctSTR = question.getString("correct");
                String messegeSTR = question.getString("messege");
                String yesSTR = question.getString("yes");
                String noStr = question.getString("no");

                questionitem.add(new Questionitem(
                        imgurlSTR,
                        questionSTR,
                        answer1STR,
                        answer2STR,
                        answer3STR,
                        correctSTR,
                        messegeSTR,
                        yesSTR,
                        noStr
                ));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    //Seting questions on screen
    private void setQuestiononScreen(int number)
    {

        String imagefile = questionitem.get(number).getImgurl();
        int resId = getResources().getIdentifier(imagefile, "drawable", getPackageName());
        Drawable imag = getResources().getDrawable(resId);
        image.setImageDrawable(imag);
        Question.setText(questionitem.get(number).getQuestion());
        Answer1.setText(questionitem.get(number).getAnswer1());
        Answer2.setText(questionitem.get(number).getAnswer2());
        Answer3.setText(questionitem.get(number).getAnswer3());
    }

    public void onBack()
    {
        new AlertDialog.Builder(this)
                .setMessage(questionitem.get(currentQuestion).getMessege())
                .setPositiveButton(questionitem.get(currentQuestion).getYes(), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        cTinmer.cancel();
                        startActivity(new Intent(getApplicationContext(),menuitems.class));
                    }
                })
                .setNegativeButton(questionitem.get(currentQuestion).getNo(), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Continue", Toast.LENGTH_SHORT).show();
                    }
                }).show();
    }
}
