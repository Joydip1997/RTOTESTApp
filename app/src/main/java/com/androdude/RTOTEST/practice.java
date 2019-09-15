package com.androdude.RTOTEST;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
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

public class practice extends AppCompatActivity {

    private Button prac1,prac2,prac3,Next1,Back1;
    private TextView Question1,cAnswers1,wAnswers1,givetest,practicetest,info,timerview;
    private ImageView image1,img2;
    List<Questionitem1> questionitem1;
    private Boolean flag;
    String flag0="",flag1="",flag2="";
    String a1="";
    String a2="";
    String a3="";
    String Flag = "";
    Boolean a=false,b=false,c=false;
    int currentQuestion1=0,correct1=0,wrong1=0,num;
    final Handler handler = new Handler();
    int time = 30000;
    Boolean isRunning = true;
    @Override
    public void onBackPressed() {
// super.onBackPressed();
        onBack();
// Not calling **super**, disables back button in current screen.
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);
        SetupView();
        //get all questions
        loadAllQuestions1();
        //Shuffeling Questions
        Collections.shuffle(questionitem1);
        //Load first question









        Back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBack();
            }
        });

        setQuestiononScreen1(num);





        prac1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a=true;
                //checking the answers if the are correct or not
                prac2.setBackgroundColor(getResources().getColor(R.color.bttn));
                prac3.setBackgroundColor(getResources().getColor(R.color.bttn));
                prac1.setBackgroundColor(Color.GREEN);
                if(questionitem1.get(currentQuestion1).getAnswer1().equals(questionitem1.get(currentQuestion1).getCorrect()))
                {
                    flag = true;
                    flag0="3";
                    prac1.setBackgroundColor(Color.GREEN);

                }
                else
                {
                    flag=false;
                    flag0="4";
                    String ans = questionitem1.get(currentQuestion1).getCorrect();
                    String right1 = questionitem1.get(currentQuestion1).getAnswer2();
                    String right2 = questionitem1.get(currentQuestion1).getAnswer3();

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



        prac2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b=true;
                //checking the answers if the are correct or not
                prac1.setBackgroundColor(getResources().getColor(R.color.bttn));
                prac3.setBackgroundColor(getResources().getColor(R.color.bttn));
                prac2.setBackgroundColor(Color.GREEN);
                if(questionitem1.get(currentQuestion1).getAnswer2().equals(questionitem1.get(currentQuestion1).getCorrect()))
                {
                    flag = true;
                    flag1="3";
                    prac2.setBackgroundColor(Color.GREEN);
                }
                else
                {

                    flag=false;
                    flag1="4";
                    String ans1 = questionitem1.get(currentQuestion1).getCorrect();
                    String right3 = questionitem1.get(currentQuestion1).getAnswer1();
                    String right4 = questionitem1.get(currentQuestion1).getAnswer3();

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

        prac3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c=true;
                //checking the answers if the are correct or not
                prac1.setBackgroundColor(getResources().getColor(R.color.bttn));
                prac2.setBackgroundColor(getResources().getColor(R.color.bttn));
                prac3.setBackgroundColor(Color.GREEN);

                if(questionitem1.get(currentQuestion1).getAnswer3().equals(questionitem1.get(currentQuestion1).getCorrect()))
                {
                    flag = true;
                    flag2="3";
                    prac3.setBackgroundColor(Color.GREEN);
                }
                else
                {
                    flag=false;
                    flag2="4";
                    String ans2 = questionitem1.get(currentQuestion1).getCorrect();
                    String right4 = questionitem1.get(currentQuestion1).getAnswer1();
                    String right5 = questionitem1.get(currentQuestion1).getAnswer2();

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


        Next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(a==true || b==true || c==true)
                {


                    if(flag0.equals("4")) {

                        if (a1.equals("1")) {
                            prac1.setBackgroundColor(Color.RED);
                            prac2.setBackgroundColor(Color.GREEN);
                            prac3.setBackgroundColor(Color.RED);
                            a1 = "-1";
                            flag0="-1";
                        } else {
                            prac1.setBackgroundColor(Color.RED);
                            prac3.setBackgroundColor(Color.GREEN);
                            prac2.setBackgroundColor(Color.RED);
                            a1 = "-1";
                            flag0="-1";
                        }
                    }

                    if(flag1.equals("4")) {
                        if(a2.equals("1"))
                        {
                            prac2.setBackgroundColor(Color.RED);
                            prac1.setBackgroundColor(Color.GREEN);
                            prac3.setBackgroundColor(Color.RED);
                            a2 = "-1";
                            flag1="-1";
                        }
                        else
                        {
                            prac1.setBackgroundColor(Color.RED);
                            prac3.setBackgroundColor(Color.GREEN);
                            prac2.setBackgroundColor(Color.RED);
                            a2 = "-1";
                            flag1="-1";
                        }

                    }



                    if(flag2.equals("4"))
                    {


                        if(a3.equals("1"))
                        {
                            prac2.setBackgroundColor(Color.RED);
                            prac1.setBackgroundColor(Color.GREEN);
                            prac3.setBackgroundColor(Color.RED);
                            a3 = "-1";
                            flag2="-1";
                        }
                        else
                        {
                            prac1.setBackgroundColor(Color.RED);
                            prac2.setBackgroundColor(Color.GREEN);
                            prac3.setBackgroundColor(Color.RED);
                            a1 = "-1";
                            flag2="-1";
                        }
                    }
                    if(flag)
                    {
                        correct1++;
                        cAnswers1.setText(String.valueOf(correct1));
                        wAnswers1.setText(String.valueOf(wrong1));
                    }
                    else
                    {
                        wrong1++;
                        cAnswers1.setText(String.valueOf(correct1));
                        wAnswers1.setText(String.valueOf(wrong1));
                    }


                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if(currentQuestion1<questionitem1.size()-1)
                            {
                                prac1.setBackgroundColor(getResources().getColor(R.color.bttn));
                                prac2.setBackgroundColor(getResources().getColor(R.color.bttn));
                                prac3.setBackgroundColor(getResources().getColor(R.color.bttn));

                                currentQuestion1++;
                                setQuestiononScreen1(currentQuestion1);


                            }
                            else
                            {
                                finish();
                                Intent endVales = new Intent(getApplicationContext(),EndActivity.class)
                                        .putExtra("CorrectAnswers",String.valueOf(correct1))
                                        .putExtra("WrongAnswers",String.valueOf(wrong1));
                                startActivity(endVales);

                            }
                        }
                    }, 1000);
                }
                else
                {
                    Toast.makeText(practice.this, "Answer The Question", Toast.LENGTH_SHORT).show();
                }


                a =false;
                b=false;
                c=false;

            }
        });





    }













    public void SetupView()
    {
        Question1 = (TextView)findViewById(R.id.practiceQuestion);
        prac1 = (Button)findViewById(R.id.prac1);
        prac2 = (Button)findViewById(R.id.prac2);
        prac3 = (Button)findViewById(R.id.prac3);
        Next1 = (Button)findViewById(R.id.next1);
        Back1 = (Button)findViewById(R.id.back1);
        image1 = (ImageView)findViewById(R.id.pracImg2);
        img2 = (ImageView)findViewById(R.id.img1);
        cAnswers1 = (TextView)findViewById(R.id.number_corect_answers1);
        wAnswers1 = (TextView)findViewById(R.id.number_wrong_answers1);

    }

    private  String loadJSONFromAssets1(String file)
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

    private void loadAllQuestions1()
    {
        questionitem1 = new ArrayList<>();

        String JsonStr = loadJSONFromAssets1("questions.JSON");

        try
        {
            JSONObject obj = new JSONObject(JsonStr);
            JSONArray questions = obj.getJSONArray("questions");
            for(int i=0;i<questions.length();i++)
            {
                JSONObject question = questions.getJSONObject(i);

                String imgurlSTR1 = question.getString("url");
                String questionSTR1 = question.getString("Question");
                String answer1STR1 = question.getString("answer1");
                String answer2STR1 = question.getString("answer2");
                String answer3STR1 = question.getString("answer3");
                String correctSTR1 = question.getString("correct");
                String messegeSTR1 = question.getString("messege");
                String yesSTR1 = question.getString("yes");
                String noStr1 = question.getString("no");

              questionitem1.add(new Questionitem1(
                     imgurlSTR1,
                     questionSTR1,
                     answer1STR1,
                     answer2STR1,
                     answer3STR1,
                     correctSTR1,
                     messegeSTR1,
                     yesSTR1,
                     noStr1
              ));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    //Seting questions on screen
    private void setQuestiononScreen1(int number)
    {
        String imagefile = questionitem1.get(number).getImgurl();
        int resId = getResources().getIdentifier(imagefile, "drawable", getPackageName());
        Drawable imag = getResources().getDrawable(resId);
        image1.setImageDrawable(imag);

        Question1.setText(questionitem1.get(number).getQuestion());
        prac1.setText(questionitem1.get(number).getAnswer1());
        prac2.setText(questionitem1.get(number).getAnswer2());
        prac3.setText(questionitem1.get(number).getAnswer3());
    }

    public void onBack()
    {
        new AlertDialog.Builder(this)
                .setMessage(questionitem1.get(currentQuestion1).getMessege())
                .setPositiveButton(questionitem1.get(currentQuestion1).getYes(), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(getApplicationContext(),menuitems.class));
                    }
                })
                .setNegativeButton(questionitem1.get(currentQuestion1).getNo(), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "Continue", Toast.LENGTH_SHORT).show();
                    }
                }).show();
    }


}
