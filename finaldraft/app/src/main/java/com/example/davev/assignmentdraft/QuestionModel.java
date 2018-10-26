package com.example.davev.assignmentdraft;

public class QuestionModel {
    private String QuestionString;
    private String Answer;

    public QuestionModel(String qString, String ans){
        QuestionString = qString;
        Answer = ans;

    }

    public String getQuestionString() {
        return QuestionString;
    }

    public void setQuestionString(String questionString) {
        QuestionString = questionString;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String answer) {
        Answer = answer;
    }
}
