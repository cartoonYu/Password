package com.example.cartoon.passwordmanager.data;



/**
 * Created by cartoon on 2018/1/27.
 */

public class PersonalInformation{
    private String password;
    private String question;
    private String answer;

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
}
