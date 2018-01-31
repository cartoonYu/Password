package com.example.cartoon.passwordmanager.data.TablePersonalInformation;



/**
 * Created by cartoon on 2018/1/27.
 */

public class PersonalInformation{
    private String password;
    private String question;
    private String answer;

    public PersonalInformation(){

    }

    public PersonalInformation(String password,String question,String answer){
        this.password=password;
        this.question=question;
        this.answer=answer;
    }

    public String getPassword() {
        return password;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
