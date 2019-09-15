package com.androdude.RTOTEST;

public class Questionitem1 {
    private String imgurl,question,answer1,answer2,answer3,correct,messege,yes,no;

    public String getCorrect() {
        return correct;
    }

    public Questionitem1(String imgurl,String question, String answer1, String answer2, String answer3, String correct,String messege,String yes,String no) {
        this.imgurl = imgurl;
        this.question = question;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.correct = correct;
        this.messege = messege;
        this.yes = yes;
        this.no = no;
    }

    public String getYes() {
        return yes;
    }

    public String getNo() {
        return no;
    }

    public String getMessege() {
        return messege;
    }

    public String getImgurl() {
        return imgurl;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer1() {
        return answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public String getAnswer3() {
        return answer3;
    }
}
