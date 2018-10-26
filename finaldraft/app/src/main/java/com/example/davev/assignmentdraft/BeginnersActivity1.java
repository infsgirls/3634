package com.example.davev.assignmentdraft;

import android.content.Intent;
import android.os.Bundle;
//import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.view.View;

//The purpose of this activity is to present the user with an initial overview of ERD's.
// It is considered to be the Beginner's Lesson for ERD's.
public class BeginnersActivity1 extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beginners1);

        //Calling the setOnClickListener method defined below so the "Next" button acts correctly.
        Button next_page = (Button) findViewById(R.id.btn_next_b1);
        next_page.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent = null;

        //Provides the intent behind teh "Next" button, which is invoked in the onCreate method.
        switch (view.getId()) {
            case R.id.btn_next_b1:
                intent = new Intent(this, BeginnersActivity2.class);
                break;


            default:

        }

        if (intent != null) {
            startActivity(intent);
        }
    }

}


//Code generated based on tutorials at https://www.udemy.com/master-android-7-nougat-java-app-development-step-by-step/  [Developed by Tim Buchalka]
//ERD overview content displayed to user sourced from https://searchdatamanagement.techtarget.com/definition/entity-relationship-diagram-ERD