package com.example.istoriaalfabetelor.utils;

import java.util.Date;

public class Trivia {
    private String name;
    private int score;
    private Date date;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private String answer5;
    private int answer6;
    private int answer7;
    private int answer8;
    private String answer9;
    private String answer10;

    public int getAnswer6() {
        return answer6;
    }

    public void setAnswer6(int answer6) {
        this.answer6 = answer6;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getAnswer5() {
        return answer5;
    }

    public void setAnswer5(String answer5) {
        this.answer5 = answer5;
    }

    public int getAnswer7() {
        return answer7;
    }

    public void setAnswer7(int answer7) {
        this.answer7 = answer7;
    }

    public int getAnswer8() {
        return answer8;
    }

    public void setAnswer8(int answer8) {
        this.answer8 = answer8;
    }

    public String getAnswer9() {
        return answer9;
    }

    public void setAnswer9(String answer9) {
        this.answer9 = answer9;
    }

    public String getAnswer10() {
        return answer10;
    }

    public void setAnswer10(String answer10) {
        this.answer10 = answer10;
    }

    public Trivia() {
    }

    public Trivia(String name, int score, String answer1, String answer2, String answer3, String answer4, String answer5, int answer6, int answer7, int answer8, String answer9, String answer10) {
        this.name = name;
        this.score = score;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.answer5 = answer5;
        this.answer6 = answer6;
        this.answer9 = answer9;
        this.answer10 = answer10;
        this.answer7 = answer7;
        this.answer8 = answer8;
        this.date = new Date();
    }

    public Trivia(String name, int score) {
        this.name = name;
        this.score = score;
        this.date = new Date();
    }

    @Override
    public String toString() {
        return "Trivia{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", date=" + date +
                '}';
    }
}
