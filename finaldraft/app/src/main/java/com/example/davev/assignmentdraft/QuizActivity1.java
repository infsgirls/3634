package com.example.davev.assignmentdraft;

import android.os.Bundle;
import android.support.annotation.NonNull;
//import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import cn.pedant.SweetAlert.SweetAlertDialog;
import java.util.ArrayList;

//This Activity is to quiz the user on what they have learnt. The several questions are all part of this
//this activity and so is the related UX and UI

public class QuizActivity1 extends AppCompatActivity {
    TextView qLabel, qCountLabel, scoreLabel;
    EditText ansEdit;
    Button submit;
    ProgressBar progressBar;
    ArrayList<QuestionModel> questionModelArrayList;

    int currentPosition = 0;
    int numberOfCorrect = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz1);



//First we link the related widgets to vairables that can later be used in methods

        qCountLabel = findViewById(R.id.qNumber);
        qLabel = findViewById(R.id.question);
        scoreLabel = findViewById(R.id.score);

        ansEdit = findViewById(R.id.answer);
        submit = findViewById(R.id.submit);
        progressBar = findViewById(R.id.progressBar);

        questionModelArrayList = new ArrayList<>();

        setUpQuestion();

        setData();
// An OnClickListen for the Submit button, used in order to move on to the next task
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();

            }
        });

    }

    //This method provides the list of questions that will be asked, it is invoked first and foremost
        public void setUpQuestion(){
            questionModelArrayList.add(new QuestionModel("An ERD is a graphical representation that depicts the ____________ among people, objects, places, concepts or events within that system.", "relationships"));
            questionModelArrayList.add(new QuestionModel("Properties or characteristics of entities are called ____________.", "attributes"));
            questionModelArrayList.add(new QuestionModel("The relationship of a customer placing an order for multiple products is a ___________ relationship.", "1:M"));
            questionModelArrayList.add(new QuestionModel("A customer who has an email address stored in a company's database is a ____________ relationship.", "1:1"));
            questionModelArrayList.add(new QuestionModel("The first step of creating an ERD is to draw the ____________ in defined boxes.", "entities"));
            questionModelArrayList.add(new QuestionModel("An important step in designing an ERD that should never be forgotten is to _________ your model with business and technical stakeholders.", "review"));
            questionModelArrayList.add(new QuestionModel("A good tip is to make sure that each entity only appears __________ per diagram.", "once"));
            questionModelArrayList.add(new QuestionModel("Every entity, relationship and attribute in your ERD should have a ___________.", "name"));
        }

        //This method is used to show the progress in questions and updated score as the user progresses through the quiz
        public void setData(){

        if(questionModelArrayList.size()>currentPosition) {


            qLabel.setText(questionModelArrayList.get(currentPosition).getQuestionString());
            qCountLabel.setText("Question No: " + (currentPosition + 1));
            scoreLabel.setText("Score: " + numberOfCorrect + "/" + questionModelArrayList.size());
        }

        //This part of the method is invoked after the last question has been.
        //It brings us the options of restarting the quiz or exiting out of it
        else{

            new SweetAlertDialog(QuizActivity1.this, SweetAlertDialog.SUCCESS_TYPE)
                    .setTitleText("You have succesfully completed the quiz")
                    .setContentText("Your scoe is :"+numberOfCorrect + "/" + questionModelArrayList.size())
                    .setConfirmText("Restart")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                                 @Override
                                                 public void onClick(SweetAlertDialog sDialog) {

                                                     sDialog.dismissWithAnimation();
                                                     currentPosition=0;
                                                     numberOfCorrect=0;
                                                     progressBar.setProgress(0);
                                                     setData();
                                                 }



            })
            .setCancelText("Close")
                    .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            sDialog.dismissWithAnimation();
                            finish();

                        }
                    })
                    .show();


        }
    }
//This part of the code executes a dialog box that shows whether the answer is wrong or right,
    //and the correct answer in case of the former.
        public void checkAnswer(){
            String answerString = ansEdit.getText().toString().trim();

            if(answerString.equalsIgnoreCase(questionModelArrayList.get(currentPosition).getAnswer())){

                numberOfCorrect++;

                Log.e("answer", "right");

                new SweetAlertDialog(QuizActivity1.this, SweetAlertDialog.SUCCESS_TYPE)
                        .setTitleText("Good job!")
                        .setContentText("Right Answer")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                currentPosition++;
                                setData();
                                ansEdit.setText("");
                                sweetAlertDialog.dismiss();
                            }
                        })
                        .show();



            }
            else{
                Log.e("answer", "wrong");

                new SweetAlertDialog(QuizActivity1.this, SweetAlertDialog.ERROR_TYPE)
                        .setTitleText("Oh no! Wrong Answer")
                        .setContentText("The right answer is: " +questionModelArrayList.get(currentPosition).getAnswer())
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                currentPosition++;
                                setData();
                                ansEdit.setText("");
                                sweetAlertDialog.dismiss();
                            }
                        })
                        .show();
            }

            int x = ((currentPosition+1)*100)/questionModelArrayList.size();

            progressBar.setProgress(x);
        }

    }

//Code generated based on tutorials at https://www.udemy.com/master-android-7-nougat-java-app-development-step-by-step/  [Developed by Tim Buchalka]
//com.github.f0ris.sweetalert:library:1.5.1 is the github liabrary used for right/wrong answer and results related UI